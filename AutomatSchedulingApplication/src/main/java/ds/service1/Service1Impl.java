// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: UserManagement.proto

package ds.service1;

public final class Service1Impl {
  private Service1Impl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service1_RequestMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service1_RequestMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_service1_ResponseMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_service1_ResponseMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016service1.proto\022\010service1\"\036\n\016RequestMes" +
      "sage\022\014\n\004text\030\001 \001(\t\"!\n\017ResponseMessage\022\016\n" +
      "\006length\030\001 \001(\0052P\n\010Service1\022D\n\013service1_do" +
      "\022\030.service1.RequestMessage\032\031.service1.Re" +
      "sponseMessage\"\000B\035\n\013ds.service1B\014Service1" +
      "ImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_service1_RequestMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_service1_RequestMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service1_RequestMessage_descriptor,
        new java.lang.String[] { "Text", });
    internal_static_service1_ResponseMessage_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_service1_ResponseMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_service1_ResponseMessage_descriptor,
        new java.lang.String[] { "Length", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
