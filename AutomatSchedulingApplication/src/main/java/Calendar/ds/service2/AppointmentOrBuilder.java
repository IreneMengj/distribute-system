// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service2.proto

package Calendar.ds.service2;

public interface AppointmentOrBuilder extends
    // @@protoc_insertion_point(interface_extends:service2.Appointment)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 id = 1;</code>
   * @return The id.
   */
  int getId();

  /**
   * <code>string title = 2;</code>
   * @return The title.
   */
  String getTitle();
  /**
   * <code>string title = 2;</code>
   * @return The bytes for title.
   */
  com.google.protobuf.ByteString
      getTitleBytes();

  /**
   * <code>string detail = 3;</code>
   * @return The detail.
   */
  String getDetail();
  /**
   * <code>string detail = 3;</code>
   * @return The bytes for detail.
   */
  com.google.protobuf.ByteString
      getDetailBytes();

  /**
   * <code>string occurTime = 4;</code>
   * @return The occurTime.
   */
  String getOccurTime();
  /**
   * <code>string occurTime = 4;</code>
   * @return The bytes for occurTime.
   */
  com.google.protobuf.ByteString
      getOccurTimeBytes();

  /**
   * <code>string reminder = 5;</code>
   * @return The reminder.
   */
  String getReminder();
  /**
   * <code>string reminder = 5;</code>
   * @return The bytes for reminder.
   */
  com.google.protobuf.ByteString
      getReminderBytes();
}
