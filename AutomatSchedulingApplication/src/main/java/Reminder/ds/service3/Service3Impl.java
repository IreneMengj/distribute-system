// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service3.proto

package Reminder.ds.service3;

public final class Service3Impl {
  private Service3Impl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service3_Response_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service3_Response_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service3_ResponseMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service3_ResponseMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service3_ReminderId_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service3_ReminderId_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service3_ID_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service3_ID_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service3_Reminder_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service3_Reminder_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\016service3.proto\022\010service3\032\033google/proto" +
      "buf/empty.proto\")\n\010Response\022\014\n\004code\030\001 \001(" +
      "\005\022\017\n\007message\030\002 \001(\t\"\"\n\017ResponseMessage\022\017\n" +
      "\007message\030\001 \001(\t\"\030\n\nReminderId\022\n\n\002ID\030\001 \003(\005" +
      "\"\020\n\002ID\022\n\n\002ID\030\001 \001(\005\"h\n\010Reminder\022\014\n\004year\030\001" +
      " \001(\t\022\r\n\005month\030\002 \001(\t\022\013\n\003day\030\003 \001(\t\022\014\n\004hour" +
      "\030\004 \001(\t\022\013\n\003min\030\005 \001(\t\022\013\n\003sec\030\006 \001(\t\022\n\n\002ID\030\007" +
      " \001(\0052\320\001\n\010Service3\0229\n\013setReminder\022\022.servi" +
      "ce3.Reminder\032\022.service3.Response\"\0000\001\022@\n\013" +
      "getReminder\022\024.service3.ReminderId\032\031.serv" +
      "ice3.ResponseMessage\"\000\022G\n\016deleteReminder" +
      "\022\024.service3.ReminderId\032\031.service3.Respon" +
      "seMessage\"\000(\0010\001B*\n\030Notification.ds.servi" +
      "ce3B\014Service3ImplP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
        });
    internal_static_service3_Response_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_service3_Response_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service3_Response_descriptor,
        new String[] { "Code", "Message", });
    internal_static_service3_ResponseMessage_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_service3_ResponseMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service3_ResponseMessage_descriptor,
        new String[] { "Message", });
    internal_static_service3_ReminderId_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_service3_ReminderId_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service3_ReminderId_descriptor,
        new String[] { "ID", });
    internal_static_service3_ID_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_service3_ID_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service3_ID_descriptor,
        new String[] { "ID", });
    internal_static_service3_Reminder_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_service3_Reminder_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service3_Reminder_descriptor,
        new String[] { "Year", "Month", "Day", "Hour", "Min", "Sec", "ID", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
