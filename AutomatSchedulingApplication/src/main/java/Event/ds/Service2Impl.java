// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: service2.proto

package Event.ds;

public final class Service2Impl {
  private Service2Impl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_eventId_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_eventId_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_eventIdList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_eventIdList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_AppointmentRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_AppointmentRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_Appointment_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_Appointment_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service2_ResponseMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service2_ResponseMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\016service2.proto\022\010service2\"\025\n\007eventId\022\n\n" +
      "\002id\030\001 \001(\005\"\037\n\013eventIdList\022\020\n\010eventIds\030\001 \003" +
      "(\005\"A\n\022AppointmentRequest\022+\n\014appointments" +
      "\030\001 \003(\0132\025.service2.Appointment\"K\n\013Appoint" +
      "ment\022\n\n\002id\030\001 \001(\005\022\r\n\005title\030\002 \001(\t\022\016\n\006detai" +
      "l\030\003 \001(\t\022\021\n\toccurTime\030\004 \001(\003\"\037\n\017ResponseMe" +
      "ssage\022\014\n\004code\030\001 \001(\0052\326\001\n\010Service2\022E\n\010addE" +
      "vent\022\034.service2.AppointmentRequest\032\031.ser" +
      "vice2.ResponseMessage\"\000\022=\n\013deleteEvent\022\021" +
      ".service2.eventId\032\031.service2.ResponseMes" +
      "sage\"\000\022D\n\013updateEvent\022\025.service2.eventId" +
      "List\032\034.service2.AppointmentRequest\"\000B&\n\024" +
      "Calendar.ds.service2B\014Service2ImplP\001b\006pr" +
      "oto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_service2_eventId_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_service2_eventId_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_eventId_descriptor,
        new String[] { "Id", });
    internal_static_service2_eventIdList_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_service2_eventIdList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_eventIdList_descriptor,
        new String[] { "EventIds", });
    internal_static_service2_AppointmentRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_service2_AppointmentRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_AppointmentRequest_descriptor,
        new String[] { "Appointments", });
    internal_static_service2_Appointment_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_service2_Appointment_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_Appointment_descriptor,
        new String[] { "Id", "Title", "Detail", "OccurTime", });
    internal_static_service2_ResponseMessage_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_service2_ResponseMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service2_ResponseMessage_descriptor,
        new String[] { "Code", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}