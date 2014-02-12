/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
*/
package org.apache.airavata.orchestrator.core.impl;


import java.io.File;
import java.net.URL;
import java.util.*;

import org.apache.airavata.client.api.AiravataAPI;
import org.apache.airavata.client.api.exception.AiravataAPIInvocationException;
import org.apache.airavata.common.utils.AiravataJobState;
import org.apache.airavata.common.utils.ServerSettings;
import org.apache.airavata.commons.gfac.type.ApplicationDescription;
import org.apache.airavata.commons.gfac.type.HostDescription;
import org.apache.airavata.commons.gfac.type.ServiceDescription;
import org.apache.airavata.gfac.Constants;
import org.apache.airavata.gfac.cpi.GFacAPI;
import org.apache.airavata.gfac.GFacConfiguration;
import org.apache.airavata.gfac.context.ApplicationContext;
import org.apache.airavata.gfac.context.JobExecutionContext;
import org.apache.airavata.gfac.context.MessageContext;
import org.apache.airavata.gfac.scheduler.HostScheduler;
import org.apache.airavata.model.experiment.ConfigurationData;
import org.apache.airavata.orchestrator.core.context.OrchestratorContext;
import org.apache.airavata.orchestrator.core.exception.OrchestratorException;
import org.apache.airavata.orchestrator.core.gfac.GFACInstance;
import org.apache.airavata.orchestrator.core.job.JobSubmitter;
import org.apache.airavata.orchestrator.core.utils.OrchestratorUtils;
import org.apache.airavata.registry.api.AiravataRegistry2;
import org.apache.airavata.registry.cpi.DataType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the simplest implementation for JobSubmitter,
 * This is calling gfac invocation methods to invoke the gfac embedded mode,so this does not really implement
 * the selectGFACInstance method
 */
public class EmbeddedGFACJobSubmitter implements JobSubmitter {
    private final static Logger logger = LoggerFactory.getLogger(EmbeddedGFACJobSubmitter.class);

    private OrchestratorContext orchestratorContext;


    public void initialize(OrchestratorContext orchestratorContext) throws OrchestratorException {
        this.orchestratorContext = orchestratorContext;
    }

    public GFACInstance selectGFACInstance() throws OrchestratorException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public boolean submitJob(GFACInstance gfac, List<String> experimentIDList) throws OrchestratorException {

        for (int i = 0; i < experimentIDList.size(); i++) {
            try {
                // once its fetched it's status will changed to fetched state
                launchGfacWithJobRequest(experimentIDList.get(i));
            } catch (Exception e) {
                logger.error("Error getting job related information");
                throw new OrchestratorException(e);
            }
        }
        return true;
    }

    //FIXME: (MEP) This method is pretty gruesome.  If we really expect multiple implementations of the JobSubmitter
    // interface and at least some of them will need to do the stuff in this method, then we need a parent class GenericJobSubmitterImpl.java (maybe abstract) that includes launchGfacWithJobRequest() so that subclasses can inherit it.
    private void launchGfacWithJobRequest(String experimentID) throws OrchestratorException {
        ConfigurationData configurationData = (ConfigurationData)
                orchestratorContext.getNewRegistry().get(DataType.EXPERIMENT_CONFIGURATION_DATA, experimentID);

        String serviceName = configurationData.getApplicationId();

        if (serviceName == null) {
            throw new OrchestratorException("Error executing the job because there is not Application Name in this Experiment");
        }
        AiravataAPI airavataAPI = null;
        try {
            airavataAPI = orchestratorContext.getOrchestratorConfiguration().getAiravataAPI();
            AiravataRegistry2 registry = orchestratorContext.getRegistry();
            List<HostDescription> registeredHosts = new ArrayList<HostDescription>();
            Map<String, ApplicationDescription> applicationDescriptors = registry.getApplicationDescriptors(serviceName);
            for (String hostDescName : applicationDescriptors.keySet()) {
                registeredHosts.add(registry.getHostDescriptor(hostDescName));
            }
            Class<? extends HostScheduler> aClass = Class.forName(ServerSettings.getHostScheduler()).asSubclass(HostScheduler.class);
            HostScheduler hostScheduler = aClass.newInstance();
            HostDescription hostDescription = hostScheduler.schedule(registeredHosts);

            ServiceDescription serviceDescription = registry.getServiceDescriptor(serviceName);

            ApplicationDescription applicationDescription = registry.getApplicationDescriptors(serviceName, hostDescription.getType().getHostName());
            // When we run getInParameters we set the actualParameter object, this has to be fixed
            //FIXME: will these class loaders work correctly in Thrift?
            //FIXME: gfac-config.xml is only under src/test.
            URL resource = EmbeddedGFACJobSubmitter.class.getClassLoader().getResource("gfac-config.xml");
            Properties configurationProperties = ServerSettings.getProperties();
            GFacConfiguration gFacConfiguration = GFacConfiguration.create(new File(resource.getPath()), airavataAPI, configurationProperties);

            JobExecutionContext jobExecutionContext = new JobExecutionContext(gFacConfiguration, serviceName);
            //Here we get only the contextheader information sent specific for this node
            //Add security context


            ApplicationContext applicationContext = new ApplicationContext();
            applicationContext.setApplicationDeploymentDescription(applicationDescription);
            applicationContext.setHostDescription(hostDescription);
            applicationContext.setServiceDescription(serviceDescription);

            jobExecutionContext.setApplicationContext(applicationContext);


            Map<String, String> experimentInputs = configurationData.getExperimentInputs();

            jobExecutionContext.setInMessageContext(new MessageContext(OrchestratorUtils.getMessageContext(experimentInputs,
                    serviceDescription.getType().getInputParametersArray())));

            HashMap<String, Object> outputData = new HashMap<String, Object>();
            jobExecutionContext.setOutMessageContext(new MessageContext(outputData));

            jobExecutionContext.setProperty(Constants.PROP_TOPIC, experimentID);
            jobExecutionContext.setExperimentID(experimentID);
            //FIXME: (MEP) GFacAPI.submitJob() throws a GFacException that isn't caught here. You want to catch this before updating the registry.
            GFacAPI gfacAPI1 = new GFacAPI();
            gfacAPI1.submitJob(jobExecutionContext);
            //FIXME: (MEP) It may be better to change the registry status in GFacAPI rather then here.
            orchestratorContext.getRegistry().changeStatus(experimentID, AiravataJobState.State.SUBMITTED);
        } catch (Exception e) {
            throw new OrchestratorException("Error launching the Job", e);
        }
    }

    public boolean directJobSubmit(String experimentID) throws OrchestratorException {
        try {
            launchGfacWithJobRequest(experimentID);
        } catch (Exception e) {
            String error = "Error launching the job : " + experimentID;
            logger.error(error);
            throw new OrchestratorException(error);
        }
        return true;
    }
}
