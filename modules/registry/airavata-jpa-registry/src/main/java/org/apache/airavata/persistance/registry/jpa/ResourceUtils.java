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
package org.apache.airavata.persistance.registry.jpa;

import org.apache.airavata.persistance.registry.jpa.model.Configuration;
import org.apache.airavata.persistance.registry.jpa.model.Gateway;
import org.apache.airavata.persistance.registry.jpa.model.Gateway_Worker;
import org.apache.airavata.persistance.registry.jpa.model.Users;
import org.apache.airavata.persistance.registry.jpa.resources.AbstractResource;
import org.apache.airavata.persistance.registry.jpa.resources.ConfigurationResource;
import org.apache.airavata.persistance.registry.jpa.resources.GatewayResource;
import org.apache.airavata.persistance.registry.jpa.resources.UserResource;
import org.apache.airavata.persistance.registry.jpa.utils.QueryGenerator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ResourceUtils {
    private static final String PERSISTENCE_UNIT_NAME = "airavata_data";
    protected static EntityManagerFactory factory;
    protected static EntityManager em;

    /**
     * @param gatewayName
     * @return
     */
    public static Resource createGateway(String gatewayName) {
        if (!isGatewayExist(gatewayName)) {
            GatewayResource gatewayResource = new GatewayResource();
            gatewayResource.setGatewayName(gatewayName);
            return gatewayResource;
        }
        return null;

    }

    /**
     * @param gatewayName
     * @return
     */
    public static boolean isGatewayExist(String gatewayName) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
        em.getTransaction().begin();
        QueryGenerator generator = new QueryGenerator(AbstractResource.GATEWAY);
        generator.setParameter(AbstractResource.GatewayConstants.GATEWAY_NAME, gatewayName);
        Query q = generator.selectQuery(em);
        Gateway gateway = (Gateway) q.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return gateway != null;
    }

    /**
     * @param gatewayName
     * @return
     */
    public static boolean removeGateway(String gatewayName) {
        try {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            em = factory.createEntityManager();
            em.getTransaction().begin();
            QueryGenerator generator = new QueryGenerator(AbstractResource.GATEWAY);
            generator.setParameter(AbstractResource.GatewayConstants.GATEWAY_NAME, gatewayName);
            Query q = generator.deleteQuery(em);
            q.executeUpdate();
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    /**
     * @param gatewayResource
     * @param userResource
     */
    public static void addGatewayWorker(GatewayResource gatewayResource, UserResource userResource) {
        try {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            em = factory.createEntityManager();
            em.getTransaction().begin();
            Gateway gateway = new Gateway();
            gateway.setGateway_name(gatewayResource.getGatewayName());
            Users user = new Users();
            user.setUser_name(userResource.getUserName());
            Gateway_Worker gatewayWorker = new Gateway_Worker();
            gatewayWorker.setGateway(gateway);
            gatewayWorker.setUser(user);
            em.persist(gatewayWorker);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @param gatewayResource
     * @param userResource
     * @return
     */
    public static boolean removeGatewayWorker(GatewayResource gatewayResource, UserResource userResource) {
        try {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            em = factory.createEntityManager();
            em.getTransaction().begin();
            QueryGenerator generator = new QueryGenerator(AbstractResource.GATEWAY_WORKER);
            generator.setParameter(AbstractResource.GatewayWorkerConstants.GATEWAY_NAME,
                    gatewayResource.getGatewayName());
            generator.setParameter(AbstractResource.UserConstants.USERNAME, userResource.getUserName());
            Query q = generator.deleteQuery(em);
            q.executeUpdate();
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * @param configKey
     * @return
     */
    public static List<ConfigurationResource> getConfigurations(String configKey) {
        List<ConfigurationResource> list = new ArrayList<ConfigurationResource>();
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
        em.getTransaction().begin();
        QueryGenerator generator = new QueryGenerator(AbstractResource.CONFIGURATION);
        generator.setParameter(AbstractResource.ConfigurationConstants.CONFIG_KEY, configKey);
        Query q = generator.selectQuery(em);
        List<?> resultList = q.getResultList();
        if (resultList.size() != 0) {
            for (Object result : resultList) {
                ConfigurationResource configurationResource = createConfigurationResourceObject(result);
                list.add(configurationResource);
            }
        }
        em.getTransaction().commit();
        em.close();
        return list;
    }

    /**
     * @param configKey
     * @return
     */
    public static ConfigurationResource getConfiguration(String configKey) {
        List<ConfigurationResource> configurations = getConfigurations(configKey);
        return (configurations != null && configurations.size() > 0) ? configurations.get(0) : null;
    }

    /**
     * @param configKey
     * @return
     */
    public static boolean isConfigurationExist(String configKey) {
        List<ConfigurationResource> configurations = getConfigurations(configKey);
        return (configurations != null && configurations.size() > 0);
    }

    /**
     * @param configKey
     * @return
     */
    public static ConfigurationResource createConfiguration(String configKey) {
        ConfigurationResource config = new ConfigurationResource();
        config.setConfigKey(configKey);
        return config;
    }

    /**
     * @param result
     * @return
     */
    private static ConfigurationResource createConfigurationResourceObject(
            Object result) {
        Configuration configuration = (Configuration) result;
        ConfigurationResource configurationResource = new ConfigurationResource(configuration.getConfig_ID());
        configurationResource.setConfigKey(configuration.getConfig_key());
        configurationResource.setConfigVal(configuration.getConfig_val());
        configurationResource.setExpireDate(configuration.getExpire_date());
        return configurationResource;
    }

    /**
     * @param configkey
     * @param configValue
     */
    public static void removeConfiguration(String configkey, String configValue) {
//        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//        em = factory.createEntityManager();
//        em.getTransaction().begin();
//        Query q = em.createQuery("Delete FROM Configuration p WHERE p.config_key = :configKey and p.config_val = :configVal");
//        q.setParameter("configKey", configkey);
//        q.setParameter("configVal", configValue);
        QueryGenerator queryGenerator = new QueryGenerator(AbstractResource.CONFIGURATION);
        queryGenerator.setParameter(AbstractResource.ConfigurationConstants.CONFIG_KEY, configkey);
        queryGenerator.setParameter(AbstractResource.ConfigurationConstants.CONFIG_VAL, configValue);
        Query q = queryGenerator.deleteQuery(em);
        q.executeUpdate();
        em.getTransaction().commit();
        em.close();

    }

    /**
     * @param configkey
     */
    public static void removeConfiguration(String configkey) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
        em.getTransaction().begin();
        QueryGenerator queryGenerator = new QueryGenerator(AbstractResource.CONFIGURATION);
        queryGenerator.setParameter(AbstractResource.ConfigurationConstants.CONFIG_KEY, configkey);
        Query q = queryGenerator.deleteQuery(em);
        q.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
