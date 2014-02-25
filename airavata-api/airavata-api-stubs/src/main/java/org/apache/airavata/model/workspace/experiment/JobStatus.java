    /*
     * Licensed to the Apache Software Foundation (ASF) under one or more
     * contributor license agreements.  See the NOTICE file distributed with
     * this work for additional information regarding copyright ownership.
     * The ASF licenses this file to You under the Apache License, Version 2.0
     * (the "License"); you may not use this file except in compliance with
     * the License.  You may obtain a copy of the License at
     *
     *     http://www.apache.org/licenses/LICENSE-2.0
     *
     * Unless required by applicable law or agreed to in writing, software
     * distributed under the License is distributed on an "AS IS" BASIS,
     * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * See the License for the specific language governing permissions and
     * limitations under the License.
     */
/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.model.workspace.experiment;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all") public class JobStatus implements org.apache.thrift.TBase<JobStatus, JobStatus._Fields>, java.io.Serializable, Cloneable, Comparable<JobStatus> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("JobStatus");

  private static final org.apache.thrift.protocol.TField JOB_STATE_FIELD_DESC = new org.apache.thrift.protocol.TField("jobState", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField TIME_OF_STATE_CHANGE_FIELD_DESC = new org.apache.thrift.protocol.TField("timeOfStateChange", org.apache.thrift.protocol.TType.I64, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new JobStatusStandardSchemeFactory());
    schemes.put(TupleScheme.class, new JobStatusTupleSchemeFactory());
  }

  /**
   * 
   * @see JobState
   */
  public JobState jobState; // required
  public long timeOfStateChange; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  @SuppressWarnings("all") public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see JobState
     */
    JOB_STATE((short)1, "jobState"),
    TIME_OF_STATE_CHANGE((short)2, "timeOfStateChange");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // JOB_STATE
          return JOB_STATE;
        case 2: // TIME_OF_STATE_CHANGE
          return TIME_OF_STATE_CHANGE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __TIMEOFSTATECHANGE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private _Fields optionals[] = {_Fields.TIME_OF_STATE_CHANGE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.JOB_STATE, new org.apache.thrift.meta_data.FieldMetaData("jobState", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, JobState.class)));
    tmpMap.put(_Fields.TIME_OF_STATE_CHANGE, new org.apache.thrift.meta_data.FieldMetaData("timeOfStateChange", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(JobStatus.class, metaDataMap);
  }

  public JobStatus() {
  }

  public JobStatus(
    JobState jobState)
  {
    this();
    this.jobState = jobState;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public JobStatus(JobStatus other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetJobState()) {
      this.jobState = other.jobState;
    }
    this.timeOfStateChange = other.timeOfStateChange;
  }

  public JobStatus deepCopy() {
    return new JobStatus(this);
  }

  @Override
  public void clear() {
    this.jobState = null;
    setTimeOfStateChangeIsSet(false);
    this.timeOfStateChange = 0;
  }

  /**
   * 
   * @see JobState
   */
  public JobState getJobState() {
    return this.jobState;
  }

  /**
   * 
   * @see JobState
   */
  public JobStatus setJobState(JobState jobState) {
    this.jobState = jobState;
    return this;
  }

  public void unsetJobState() {
    this.jobState = null;
  }

  /** Returns true if field jobState is set (has been assigned a value) and false otherwise */
  public boolean isSetJobState() {
    return this.jobState != null;
  }

  public void setJobStateIsSet(boolean value) {
    if (!value) {
      this.jobState = null;
    }
  }

  public long getTimeOfStateChange() {
    return this.timeOfStateChange;
  }

  public JobStatus setTimeOfStateChange(long timeOfStateChange) {
    this.timeOfStateChange = timeOfStateChange;
    setTimeOfStateChangeIsSet(true);
    return this;
  }

  public void unsetTimeOfStateChange() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TIMEOFSTATECHANGE_ISSET_ID);
  }

  /** Returns true if field timeOfStateChange is set (has been assigned a value) and false otherwise */
  public boolean isSetTimeOfStateChange() {
    return EncodingUtils.testBit(__isset_bitfield, __TIMEOFSTATECHANGE_ISSET_ID);
  }

  public void setTimeOfStateChangeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TIMEOFSTATECHANGE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case JOB_STATE:
      if (value == null) {
        unsetJobState();
      } else {
        setJobState((JobState)value);
      }
      break;

    case TIME_OF_STATE_CHANGE:
      if (value == null) {
        unsetTimeOfStateChange();
      } else {
        setTimeOfStateChange((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case JOB_STATE:
      return getJobState();

    case TIME_OF_STATE_CHANGE:
      return Long.valueOf(getTimeOfStateChange());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case JOB_STATE:
      return isSetJobState();
    case TIME_OF_STATE_CHANGE:
      return isSetTimeOfStateChange();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof JobStatus)
      return this.equals((JobStatus)that);
    return false;
  }

  public boolean equals(JobStatus that) {
    if (that == null)
      return false;

    boolean this_present_jobState = true && this.isSetJobState();
    boolean that_present_jobState = true && that.isSetJobState();
    if (this_present_jobState || that_present_jobState) {
      if (!(this_present_jobState && that_present_jobState))
        return false;
      if (!this.jobState.equals(that.jobState))
        return false;
    }

    boolean this_present_timeOfStateChange = true && this.isSetTimeOfStateChange();
    boolean that_present_timeOfStateChange = true && that.isSetTimeOfStateChange();
    if (this_present_timeOfStateChange || that_present_timeOfStateChange) {
      if (!(this_present_timeOfStateChange && that_present_timeOfStateChange))
        return false;
      if (this.timeOfStateChange != that.timeOfStateChange)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(JobStatus other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetJobState()).compareTo(other.isSetJobState());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetJobState()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.jobState, other.jobState);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTimeOfStateChange()).compareTo(other.isSetTimeOfStateChange());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimeOfStateChange()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timeOfStateChange, other.timeOfStateChange);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("JobStatus(");
    boolean first = true;

    sb.append("jobState:");
    if (this.jobState == null) {
      sb.append("null");
    } else {
      sb.append(this.jobState);
    }
    first = false;
    if (isSetTimeOfStateChange()) {
      if (!first) sb.append(", ");
      sb.append("timeOfStateChange:");
      sb.append(this.timeOfStateChange);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (jobState == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'jobState' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class JobStatusStandardSchemeFactory implements SchemeFactory {
    public JobStatusStandardScheme getScheme() {
      return new JobStatusStandardScheme();
    }
  }

  private static class JobStatusStandardScheme extends StandardScheme<JobStatus> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, JobStatus struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // JOB_STATE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.jobState = JobState.findByValue(iprot.readI32());
              struct.setJobStateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TIME_OF_STATE_CHANGE
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.timeOfStateChange = iprot.readI64();
              struct.setTimeOfStateChangeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, JobStatus struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.jobState != null) {
        oprot.writeFieldBegin(JOB_STATE_FIELD_DESC);
        oprot.writeI32(struct.jobState.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.isSetTimeOfStateChange()) {
        oprot.writeFieldBegin(TIME_OF_STATE_CHANGE_FIELD_DESC);
        oprot.writeI64(struct.timeOfStateChange);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class JobStatusTupleSchemeFactory implements SchemeFactory {
    public JobStatusTupleScheme getScheme() {
      return new JobStatusTupleScheme();
    }
  }

  private static class JobStatusTupleScheme extends TupleScheme<JobStatus> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, JobStatus struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.jobState.getValue());
      BitSet optionals = new BitSet();
      if (struct.isSetTimeOfStateChange()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetTimeOfStateChange()) {
        oprot.writeI64(struct.timeOfStateChange);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, JobStatus struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.jobState = JobState.findByValue(iprot.readI32());
      struct.setJobStateIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.timeOfStateChange = iprot.readI64();
        struct.setTimeOfStateChangeIsSet(true);
      }
    }
  }

}

