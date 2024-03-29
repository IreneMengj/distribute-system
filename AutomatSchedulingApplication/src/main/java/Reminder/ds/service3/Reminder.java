// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service3.proto

package Reminder.ds.service3;

/**
 * Protobuf type {@code service3.Reminder}
 */
public final class Reminder extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:service3.Reminder)
    ReminderOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Reminder.newBuilder() to construct.
  private Reminder(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  public Reminder() {
    year_ = "";
    month_ = "";
    day_ = "";
    hour_ = "";
    min_ = "";
    sec_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new Reminder();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return Service3Impl.internal_static_service3_Reminder_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return Service3Impl.internal_static_service3_Reminder_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            Reminder.class, Builder.class);
  }

  public static final int YEAR_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile Object year_ = "";
  /**
   * <code>string year = 1;</code>
   * @return The year.
   */
  @Override
  public String getYear() {
    Object ref = year_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      year_ = s;
      return s;
    }
  }
  /**
   * <code>string year = 1;</code>
   * @return The bytes for year.
   */
  @Override
  public com.google.protobuf.ByteString
      getYearBytes() {
    Object ref = year_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      year_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MONTH_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile Object month_ = "";
  /**
   * <code>string month = 2;</code>
   * @return The month.
   */
  @Override
  public String getMonth() {
    Object ref = month_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      month_ = s;
      return s;
    }
  }
  /**
   * <code>string month = 2;</code>
   * @return The bytes for month.
   */
  @Override
  public com.google.protobuf.ByteString
      getMonthBytes() {
    Object ref = month_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      month_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DAY_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile Object day_ = "";
  /**
   * <code>string day = 3;</code>
   * @return The day.
   */
  @Override
  public String getDay() {
    Object ref = day_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      day_ = s;
      return s;
    }
  }
  /**
   * <code>string day = 3;</code>
   * @return The bytes for day.
   */
  @Override
  public com.google.protobuf.ByteString
      getDayBytes() {
    Object ref = day_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      day_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int HOUR_FIELD_NUMBER = 4;
  @SuppressWarnings("serial")
  private volatile Object hour_ = "";
  /**
   * <code>string hour = 4;</code>
   * @return The hour.
   */
  @Override
  public String getHour() {
    Object ref = hour_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      hour_ = s;
      return s;
    }
  }
  /**
   * <code>string hour = 4;</code>
   * @return The bytes for hour.
   */
  @Override
  public com.google.protobuf.ByteString
      getHourBytes() {
    Object ref = hour_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      hour_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MIN_FIELD_NUMBER = 5;
  @SuppressWarnings("serial")
  private volatile Object min_ = "";
  /**
   * <code>string min = 5;</code>
   * @return The min.
   */
  @Override
  public String getMin() {
    Object ref = min_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      min_ = s;
      return s;
    }
  }
  /**
   * <code>string min = 5;</code>
   * @return The bytes for min.
   */
  @Override
  public com.google.protobuf.ByteString
      getMinBytes() {
    Object ref = min_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      min_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SEC_FIELD_NUMBER = 6;
  @SuppressWarnings("serial")
  private volatile Object sec_ = "";
  /**
   * <code>string sec = 6;</code>
   * @return The sec.
   */
  @Override
  public String getSec() {
    Object ref = sec_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      sec_ = s;
      return s;
    }
  }
  /**
   * <code>string sec = 6;</code>
   * @return The bytes for sec.
   */
  @Override
  public com.google.protobuf.ByteString
      getSecBytes() {
    Object ref = sec_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      sec_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ID_FIELD_NUMBER = 7;
  private int iD_ = 0;
  /**
   * <code>int32 ID = 7;</code>
   * @return The iD.
   */
  @Override
  public int getID() {
    return iD_;
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

      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, year_);


      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, month_);


      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, day_);


      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, hour_);


      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, min_);


      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, sec_);

    if (iD_ != 0) {
      output.writeInt32(7, iD_);
    }
    getUnknownFields().writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;

      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, year_);


      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, month_);


      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, day_);


      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, hour_);


      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, min_);


      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, sec_);

    if (iD_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(7, iD_);
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
    if (!(obj instanceof Reminder)) {
      return super.equals(obj);
    }
    Reminder other = (Reminder) obj;

    if (!getYear()
        .equals(other.getYear())) return false;
    if (!getMonth()
        .equals(other.getMonth())) return false;
    if (!getDay()
        .equals(other.getDay())) return false;
    if (!getHour()
        .equals(other.getHour())) return false;
    if (!getMin()
        .equals(other.getMin())) return false;
    if (!getSec()
        .equals(other.getSec())) return false;
    if (getID()
        != other.getID()) return false;
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
    hash = (37 * hash) + YEAR_FIELD_NUMBER;
    hash = (53 * hash) + getYear().hashCode();
    hash = (37 * hash) + MONTH_FIELD_NUMBER;
    hash = (53 * hash) + getMonth().hashCode();
    hash = (37 * hash) + DAY_FIELD_NUMBER;
    hash = (53 * hash) + getDay().hashCode();
    hash = (37 * hash) + HOUR_FIELD_NUMBER;
    hash = (53 * hash) + getHour().hashCode();
    hash = (37 * hash) + MIN_FIELD_NUMBER;
    hash = (53 * hash) + getMin().hashCode();
    hash = (37 * hash) + SEC_FIELD_NUMBER;
    hash = (53 * hash) + getSec().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getID();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static Reminder parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Reminder parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Reminder parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Reminder parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Reminder parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Reminder parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Reminder parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Reminder parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static Reminder parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static Reminder parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static Reminder parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Reminder parseFrom(
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
  public static Builder newBuilder(Reminder prototype) {
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
   * Protobuf type {@code service3.Reminder}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:service3.Reminder)
      ReminderOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Service3Impl.internal_static_service3_Reminder_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Service3Impl.internal_static_service3_Reminder_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Reminder.class, Builder.class);
    }

    // Construct using Reminder.ds.service3.Reminder.newBuilder()
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
      year_ = "";
      month_ = "";
      day_ = "";
      hour_ = "";
      min_ = "";
      sec_ = "";
      iD_ = 0;
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return Service3Impl.internal_static_service3_Reminder_descriptor;
    }

    @Override
    public Reminder getDefaultInstanceForType() {
      return Reminder.getDefaultInstance();
    }

    @Override
    public Reminder build() {
      Reminder result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public Reminder buildPartial() {
      Reminder result = new Reminder(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(Reminder result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.year_ = year_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.month_ = month_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.day_ = day_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.hour_ = hour_;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.min_ = min_;
      }
      if (((from_bitField0_ & 0x00000020) != 0)) {
        result.sec_ = sec_;
      }
      if (((from_bitField0_ & 0x00000040) != 0)) {
        result.iD_ = iD_;
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
      if (other instanceof Reminder) {
        return mergeFrom((Reminder)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(Reminder other) {
      if (other == Reminder.getDefaultInstance()) return this;
      if (!other.getYear().isEmpty()) {
        year_ = other.year_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getMonth().isEmpty()) {
        month_ = other.month_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (!other.getDay().isEmpty()) {
        day_ = other.day_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (!other.getHour().isEmpty()) {
        hour_ = other.hour_;
        bitField0_ |= 0x00000008;
        onChanged();
      }
      if (!other.getMin().isEmpty()) {
        min_ = other.min_;
        bitField0_ |= 0x00000010;
        onChanged();
      }
      if (!other.getSec().isEmpty()) {
        sec_ = other.sec_;
        bitField0_ |= 0x00000020;
        onChanged();
      }
      if (other.getID() != 0) {
        setID(other.getID());
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
            case 10: {
              year_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              month_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              day_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 34: {
              hour_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000008;
              break;
            } // case 34
            case 42: {
              min_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000010;
              break;
            } // case 42
            case 50: {
              sec_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000020;
              break;
            } // case 50
            case 56: {
              iD_ = input.readInt32();
              bitField0_ |= 0x00000040;
              break;
            } // case 56
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

    private Object year_ = "";
    /**
     * <code>string year = 1;</code>
     * @return The year.
     */
    public String getYear() {
      Object ref = year_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        year_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string year = 1;</code>
     * @return The bytes for year.
     */
    public com.google.protobuf.ByteString
        getYearBytes() {
      Object ref = year_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        year_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string year = 1;</code>
     * @param value The year to set.
     * @return This builder for chaining.
     */
    public Builder setYear(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      year_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string year = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearYear() {
      year_ = getDefaultInstance().getYear();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string year = 1;</code>
     * @param value The bytes for year to set.
     * @return This builder for chaining.
     */
    public Builder setYearBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      year_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private Object month_ = "";
    /**
     * <code>string month = 2;</code>
     * @return The month.
     */
    public String getMonth() {
      Object ref = month_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        month_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string month = 2;</code>
     * @return The bytes for month.
     */
    public com.google.protobuf.ByteString
        getMonthBytes() {
      Object ref = month_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        month_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string month = 2;</code>
     * @param value The month to set.
     * @return This builder for chaining.
     */
    public Builder setMonth(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      month_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string month = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMonth() {
      month_ = getDefaultInstance().getMonth();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string month = 2;</code>
     * @param value The bytes for month to set.
     * @return This builder for chaining.
     */
    public Builder setMonthBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      month_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private Object day_ = "";
    /**
     * <code>string day = 3;</code>
     * @return The day.
     */
    public String getDay() {
      Object ref = day_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        day_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string day = 3;</code>
     * @return The bytes for day.
     */
    public com.google.protobuf.ByteString
        getDayBytes() {
      Object ref = day_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        day_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string day = 3;</code>
     * @param value The day to set.
     * @return This builder for chaining.
     */
    public Builder setDay(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      day_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string day = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearDay() {
      day_ = getDefaultInstance().getDay();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string day = 3;</code>
     * @param value The bytes for day to set.
     * @return This builder for chaining.
     */
    public Builder setDayBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      day_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private Object hour_ = "";
    /**
     * <code>string hour = 4;</code>
     * @return The hour.
     */
    public String getHour() {
      Object ref = hour_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        hour_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string hour = 4;</code>
     * @return The bytes for hour.
     */
    public com.google.protobuf.ByteString
        getHourBytes() {
      Object ref = hour_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        hour_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string hour = 4;</code>
     * @param value The hour to set.
     * @return This builder for chaining.
     */
    public Builder setHour(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      hour_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>string hour = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearHour() {
      hour_ = getDefaultInstance().getHour();
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <code>string hour = 4;</code>
     * @param value The bytes for hour to set.
     * @return This builder for chaining.
     */
    public Builder setHourBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      hour_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }

    private Object min_ = "";
    /**
     * <code>string min = 5;</code>
     * @return The min.
     */
    public String getMin() {
      Object ref = min_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        min_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string min = 5;</code>
     * @return The bytes for min.
     */
    public com.google.protobuf.ByteString
        getMinBytes() {
      Object ref = min_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        min_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string min = 5;</code>
     * @param value The min to set.
     * @return This builder for chaining.
     */
    public Builder setMin(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      min_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>string min = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearMin() {
      min_ = getDefaultInstance().getMin();
      bitField0_ = (bitField0_ & ~0x00000010);
      onChanged();
      return this;
    }
    /**
     * <code>string min = 5;</code>
     * @param value The bytes for min to set.
     * @return This builder for chaining.
     */
    public Builder setMinBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      min_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }

    private Object sec_ = "";
    /**
     * <code>string sec = 6;</code>
     * @return The sec.
     */
    public String getSec() {
      Object ref = sec_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        sec_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string sec = 6;</code>
     * @return The bytes for sec.
     */
    public com.google.protobuf.ByteString
        getSecBytes() {
      Object ref = sec_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        sec_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string sec = 6;</code>
     * @param value The sec to set.
     * @return This builder for chaining.
     */
    public Builder setSec(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      sec_ = value;
      bitField0_ |= 0x00000020;
      onChanged();
      return this;
    }
    /**
     * <code>string sec = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearSec() {
      sec_ = getDefaultInstance().getSec();
      bitField0_ = (bitField0_ & ~0x00000020);
      onChanged();
      return this;
    }
    /**
     * <code>string sec = 6;</code>
     * @param value The bytes for sec to set.
     * @return This builder for chaining.
     */
    public Builder setSecBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      sec_ = value;
      bitField0_ |= 0x00000020;
      onChanged();
      return this;
    }

    private int iD_ ;
    /**
     * <code>int32 ID = 7;</code>
     * @return The iD.
     */
    @Override
    public int getID() {
      return iD_;
    }
    /**
     * <code>int32 ID = 7;</code>
     * @param value The iD to set.
     * @return This builder for chaining.
     */
    public Builder setID(int value) {
      
      iD_ = value;
      bitField0_ |= 0x00000040;
      onChanged();
      return this;
    }
    /**
     * <code>int32 ID = 7;</code>
     * @return This builder for chaining.
     */
    public Builder clearID() {
      bitField0_ = (bitField0_ & ~0x00000040);
      iD_ = 0;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:service3.Reminder)
  }

  // @@protoc_insertion_point(class_scope:service3.Reminder)
  private static final Reminder DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Reminder();
  }

  public static Reminder getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Reminder>
      PARSER = new com.google.protobuf.AbstractParser<Reminder>() {
    @Override
    public Reminder parsePartialFrom(
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

  public static com.google.protobuf.Parser<Reminder> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<Reminder> getParserForType() {
    return PARSER;
  }

  @Override
  public Reminder getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

