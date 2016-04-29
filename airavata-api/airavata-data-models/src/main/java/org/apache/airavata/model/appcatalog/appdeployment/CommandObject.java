/**
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
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.model.appcatalog.appdeployment;

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
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
/**
 * Job commands to be used in Pre Job, Post Job and Module Load Commands
 * 
 * command:
 *   The actual command in string format
 * 
 * commandOrder:
 *   Order of the command in the multiple command situation
 */
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-04-29")
public class CommandObject implements org.apache.thrift.TBase<CommandObject, CommandObject._Fields>, java.io.Serializable, Cloneable, Comparable<CommandObject> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CommandObject");

  private static final org.apache.thrift.protocol.TField COMMAND_FIELD_DESC = new org.apache.thrift.protocol.TField("command", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField COMMAND_ORDER_FIELD_DESC = new org.apache.thrift.protocol.TField("commandOrder", org.apache.thrift.protocol.TType.I32, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new CommandObjectStandardSchemeFactory());
    schemes.put(TupleScheme.class, new CommandObjectTupleSchemeFactory());
  }

  private String command; // required
  private int commandOrder; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    COMMAND((short)1, "command"),
    COMMAND_ORDER((short)2, "commandOrder");

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
        case 1: // COMMAND
          return COMMAND;
        case 2: // COMMAND_ORDER
          return COMMAND_ORDER;
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
  private static final int __COMMANDORDER_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.COMMAND_ORDER};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.COMMAND, new org.apache.thrift.meta_data.FieldMetaData("command", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.COMMAND_ORDER, new org.apache.thrift.meta_data.FieldMetaData("commandOrder", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CommandObject.class, metaDataMap);
  }

  public CommandObject() {
  }

  public CommandObject(
    String command)
  {
    this();
    this.command = command;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public CommandObject(CommandObject other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetCommand()) {
      this.command = other.command;
    }
    this.commandOrder = other.commandOrder;
  }

  public CommandObject deepCopy() {
    return new CommandObject(this);
  }

  @Override
  public void clear() {
    this.command = null;
    setCommandOrderIsSet(false);
    this.commandOrder = 0;
  }

  public String getCommand() {
    return this.command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public void unsetCommand() {
    this.command = null;
  }

  /** Returns true if field command is set (has been assigned a value) and false otherwise */
  public boolean isSetCommand() {
    return this.command != null;
  }

  public void setCommandIsSet(boolean value) {
    if (!value) {
      this.command = null;
    }
  }

  public int getCommandOrder() {
    return this.commandOrder;
  }

  public void setCommandOrder(int commandOrder) {
    this.commandOrder = commandOrder;
    setCommandOrderIsSet(true);
  }

  public void unsetCommandOrder() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __COMMANDORDER_ISSET_ID);
  }

  /** Returns true if field commandOrder is set (has been assigned a value) and false otherwise */
  public boolean isSetCommandOrder() {
    return EncodingUtils.testBit(__isset_bitfield, __COMMANDORDER_ISSET_ID);
  }

  public void setCommandOrderIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __COMMANDORDER_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case COMMAND:
      if (value == null) {
        unsetCommand();
      } else {
        setCommand((String)value);
      }
      break;

    case COMMAND_ORDER:
      if (value == null) {
        unsetCommandOrder();
      } else {
        setCommandOrder((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case COMMAND:
      return getCommand();

    case COMMAND_ORDER:
      return getCommandOrder();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case COMMAND:
      return isSetCommand();
    case COMMAND_ORDER:
      return isSetCommandOrder();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof CommandObject)
      return this.equals((CommandObject)that);
    return false;
  }

  public boolean equals(CommandObject that) {
    if (that == null)
      return false;

    boolean this_present_command = true && this.isSetCommand();
    boolean that_present_command = true && that.isSetCommand();
    if (this_present_command || that_present_command) {
      if (!(this_present_command && that_present_command))
        return false;
      if (!this.command.equals(that.command))
        return false;
    }

    boolean this_present_commandOrder = true && this.isSetCommandOrder();
    boolean that_present_commandOrder = true && that.isSetCommandOrder();
    if (this_present_commandOrder || that_present_commandOrder) {
      if (!(this_present_commandOrder && that_present_commandOrder))
        return false;
      if (this.commandOrder != that.commandOrder)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_command = true && (isSetCommand());
    list.add(present_command);
    if (present_command)
      list.add(command);

    boolean present_commandOrder = true && (isSetCommandOrder());
    list.add(present_commandOrder);
    if (present_commandOrder)
      list.add(commandOrder);

    return list.hashCode();
  }

  @Override
  public int compareTo(CommandObject other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCommand()).compareTo(other.isSetCommand());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCommand()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.command, other.command);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetCommandOrder()).compareTo(other.isSetCommandOrder());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCommandOrder()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.commandOrder, other.commandOrder);
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
    StringBuilder sb = new StringBuilder("CommandObject(");
    boolean first = true;

    sb.append("command:");
    if (this.command == null) {
      sb.append("null");
    } else {
      sb.append(this.command);
    }
    first = false;
    if (isSetCommandOrder()) {
      if (!first) sb.append(", ");
      sb.append("commandOrder:");
      sb.append(this.commandOrder);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetCommand()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'command' is unset! Struct:" + toString());
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

  private static class CommandObjectStandardSchemeFactory implements SchemeFactory {
    public CommandObjectStandardScheme getScheme() {
      return new CommandObjectStandardScheme();
    }
  }

  private static class CommandObjectStandardScheme extends StandardScheme<CommandObject> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, CommandObject struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // COMMAND
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.command = iprot.readString();
              struct.setCommandIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COMMAND_ORDER
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.commandOrder = iprot.readI32();
              struct.setCommandOrderIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, CommandObject struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.command != null) {
        oprot.writeFieldBegin(COMMAND_FIELD_DESC);
        oprot.writeString(struct.command);
        oprot.writeFieldEnd();
      }
      if (struct.isSetCommandOrder()) {
        oprot.writeFieldBegin(COMMAND_ORDER_FIELD_DESC);
        oprot.writeI32(struct.commandOrder);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CommandObjectTupleSchemeFactory implements SchemeFactory {
    public CommandObjectTupleScheme getScheme() {
      return new CommandObjectTupleScheme();
    }
  }

  private static class CommandObjectTupleScheme extends TupleScheme<CommandObject> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, CommandObject struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.command);
      BitSet optionals = new BitSet();
      if (struct.isSetCommandOrder()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetCommandOrder()) {
        oprot.writeI32(struct.commandOrder);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, CommandObject struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.command = iprot.readString();
      struct.setCommandIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.commandOrder = iprot.readI32();
        struct.setCommandOrderIsSet(true);
      }
    }
  }

}

