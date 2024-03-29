// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service2.proto

package Appointment.ds.service2;

/**
 * Protobuf type {@code service2.Response}
 */
public final class Response extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:service2.Response)
    ResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Response.newBuilder() to construct.
  private Response(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Response() {
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new Response();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return Service2Impl.internal_static_service2_Response_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return Service2Impl.internal_static_service2_Response_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            Response.class, Builder.class);
  }

  public static final int CODE_FIELD_NUMBER = 1;
  private int code_ = 0;
  /**
   * <code>int32 code = 1;</code>
   * @return The code.
   */
  @Override
  public int getCode() {
    return code_;
  }

  public static final int APPOINTMENT_FIELD_NUMBER = 2;
  private Appointment appointment_;
  /**
   * <code>.service2.Appointment appointment = 2;</code>
   * @return Whether the appointment field is set.
   */
  @Override
  public boolean hasAppointment() {
    return appointment_ != null;
  }
  /**
   * <code>.service2.Appointment appointment = 2;</code>
   * @return The appointment.
   */
  @Override
  public Appointment getAppointment() {
    return appointment_ == null ? Appointment.getDefaultInstance() : appointment_;
  }
  /**
   * <code>.service2.Appointment appointment = 2;</code>
   */
  @Override
  public AppointmentOrBuilder getAppointmentOrBuilder() {
    return appointment_ == null ? Appointment.getDefaultInstance() : appointment_;
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (code_ != 0) {
      output.writeInt32(1, code_);
    }
    if (appointment_ != null) {
      output.writeMessage(2, getAppointment());
    }
    getUnknownFields().writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (code_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, code_);
    }
    if (appointment_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getAppointment());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof Response)) {
      return super.equals(obj);
    }
    Response other = (Response) obj;

    if (getCode()
        != other.getCode()) return false;
    if (hasAppointment() != other.hasAppointment()) return false;
    if (hasAppointment()) {
      if (!getAppointment()
          .equals(other.getAppointment())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CODE_FIELD_NUMBER;
    hash = (53 * hash) + getCode();
    if (hasAppointment()) {
      hash = (37 * hash) + APPOINTMENT_FIELD_NUMBER;
      hash = (53 * hash) + getAppointment().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static Response parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Response parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Response parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Response parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Response parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Response parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Response parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Response parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static Response parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static Response parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static Response parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Response parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(Response prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code service2.Response}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:service2.Response)
      ResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Service2Impl.internal_static_service2_Response_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Service2Impl.internal_static_service2_Response_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Response.class, Builder.class);
    }

    // Construct using Appointment.ds.service2.Response.newBuilder()
    private Builder() {

    }

    private Builder(
        BuilderParent parent) {
      super(parent);

    }
    @Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      code_ = 0;
      appointment_ = null;
      if (appointmentBuilder_ != null) {
        appointmentBuilder_.dispose();
        appointmentBuilder_ = null;
      }
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return Service2Impl.internal_static_service2_Response_descriptor;
    }

    @Override
    public Response getDefaultInstanceForType() {
      return Response.getDefaultInstance();
    }

    @Override
    public Response build() {
      Response result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public Response buildPartial() {
      Response result = new Response(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(Response result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.code_ = code_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.appointment_ = appointmentBuilder_ == null
            ? appointment_
            : appointmentBuilder_.build();
      }
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof Response) {
        return mergeFrom((Response)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(Response other) {
      if (other == Response.getDefaultInstance()) return this;
      if (other.getCode() != 0) {
        setCode(other.getCode());
      }
      if (other.hasAppointment()) {
        mergeAppointment(other.getAppointment());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              code_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              input.readMessage(
                  getAppointmentFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            default: {
//              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
//                done = true; // was an endgroup tag
//              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int code_ ;
    /**
     * <code>int32 code = 1;</code>
     * @return The code.
     */
    @Override
    public int getCode() {
      return code_;
    }
    /**
     * <code>int32 code = 1;</code>
     * @param value The code to set.
     * @return This builder for chaining.
     */
    public Builder setCode(int value) {
      
      code_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 code = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearCode() {
      bitField0_ = (bitField0_ & ~0x00000001);
      code_ = 0;
      onChanged();
      return this;
    }

    private Appointment appointment_;
    private com.google.protobuf.SingleFieldBuilderV3<
        Appointment, Appointment.Builder, AppointmentOrBuilder> appointmentBuilder_;
    /**
     * <code>.service2.Appointment appointment = 2;</code>
     * @return Whether the appointment field is set.
     */
    public boolean hasAppointment() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.service2.Appointment appointment = 2;</code>
     * @return The appointment.
     */
    public Appointment getAppointment() {
      if (appointmentBuilder_ == null) {
        return appointment_ == null ? Appointment.getDefaultInstance() : appointment_;
      } else {
        return appointmentBuilder_.getMessage();
      }
    }
    /**
     * <code>.service2.Appointment appointment = 2;</code>
     */
    public Builder setAppointment(Appointment value) {
      if (appointmentBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        appointment_ = value;
      } else {
        appointmentBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.service2.Appointment appointment = 2;</code>
     */
    public Builder setAppointment(
        Appointment.Builder builderForValue) {
      if (appointmentBuilder_ == null) {
        appointment_ = builderForValue.build();
      } else {
        appointmentBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.service2.Appointment appointment = 2;</code>
     */
    public Builder mergeAppointment(Appointment value) {
      if (appointmentBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          appointment_ != null &&
          appointment_ != Appointment.getDefaultInstance()) {
          getAppointmentBuilder().mergeFrom(value);
        } else {
          appointment_ = value;
        }
      } else {
        appointmentBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.service2.Appointment appointment = 2;</code>
     */
    public Builder clearAppointment() {
      bitField0_ = (bitField0_ & ~0x00000002);
      appointment_ = null;
      if (appointmentBuilder_ != null) {
        appointmentBuilder_.dispose();
        appointmentBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.service2.Appointment appointment = 2;</code>
     */
    public Appointment.Builder getAppointmentBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getAppointmentFieldBuilder().getBuilder();
    }
    /**
     * <code>.service2.Appointment appointment = 2;</code>
     */
    public AppointmentOrBuilder getAppointmentOrBuilder() {
      if (appointmentBuilder_ != null) {
        return appointmentBuilder_.getMessageOrBuilder();
      } else {
        return appointment_ == null ?
            Appointment.getDefaultInstance() : appointment_;
      }
    }
    /**
     * <code>.service2.Appointment appointment = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        Appointment, Appointment.Builder, AppointmentOrBuilder>
        getAppointmentFieldBuilder() {
      if (appointmentBuilder_ == null) {
        appointmentBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            Appointment, Appointment.Builder, AppointmentOrBuilder>(
                getAppointment(),
                getParentForChildren(),
                isClean());
        appointment_ = null;
      }
      return appointmentBuilder_;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:service2.Response)
  }

  // @@protoc_insertion_point(class_scope:service2.Response)
  private static final Response DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Response();
  }

  public static Response getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Response>
      PARSER = new com.google.protobuf.AbstractParser<Response>() {
    @Override
    public Response parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<Response> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<Response> getParserForType() {
    return PARSER;
  }

  @Override
  public Response getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

