package Reminder.ds.service3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: service3.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class Service3Grpc {

  private Service3Grpc() {}

  public static final String SERVICE_NAME = "service3.Service3";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Reminder,
      Response> getSetReminderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setReminder",
      requestType = Reminder.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<Reminder,
      Response> getSetReminderMethod() {
    io.grpc.MethodDescriptor<Reminder, Response> getSetReminderMethod;
    if ((getSetReminderMethod = Service3Grpc.getSetReminderMethod) == null) {
      synchronized (Service3Grpc.class) {
        if ((getSetReminderMethod = Service3Grpc.getSetReminderMethod) == null) {
          Service3Grpc.getSetReminderMethod = getSetReminderMethod =
              io.grpc.MethodDescriptor.<Reminder, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setReminder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Reminder.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
              .setSchemaDescriptor(new Service3MethodDescriptorSupplier("setReminder"))
              .build();
        }
      }
    }
    return getSetReminderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ReminderId,
      ResponseMessage> getGetReminderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getReminder",
      requestType = ReminderId.class,
      responseType = ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ReminderId,
      ResponseMessage> getGetReminderMethod() {
    io.grpc.MethodDescriptor<ReminderId, ResponseMessage> getGetReminderMethod;
    if ((getGetReminderMethod = Service3Grpc.getGetReminderMethod) == null) {
      synchronized (Service3Grpc.class) {
        if ((getGetReminderMethod = Service3Grpc.getGetReminderMethod) == null) {
          Service3Grpc.getGetReminderMethod = getGetReminderMethod =
              io.grpc.MethodDescriptor.<ReminderId, ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getReminder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ReminderId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ResponseMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Service3MethodDescriptorSupplier("getReminder"))
              .build();
        }
      }
    }
    return getGetReminderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ReminderId,
      ResponseMessage> getDeleteReminderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteReminder",
      requestType = ReminderId.class,
      responseType = ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ReminderId,
      ResponseMessage> getDeleteReminderMethod() {
    io.grpc.MethodDescriptor<ReminderId, ResponseMessage> getDeleteReminderMethod;
    if ((getDeleteReminderMethod = Service3Grpc.getDeleteReminderMethod) == null) {
      synchronized (Service3Grpc.class) {
        if ((getDeleteReminderMethod = Service3Grpc.getDeleteReminderMethod) == null) {
          Service3Grpc.getDeleteReminderMethod = getDeleteReminderMethod =
              io.grpc.MethodDescriptor.<ReminderId, ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteReminder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ReminderId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ResponseMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Service3MethodDescriptorSupplier("deleteReminder"))
              .build();
        }
      }
    }
    return getDeleteReminderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Service3Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Service3Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Service3Stub>() {
        @Override
        public Service3Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Service3Stub(channel, callOptions);
        }
      };
    return Service3Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Service3BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Service3BlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Service3BlockingStub>() {
        @Override
        public Service3BlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Service3BlockingStub(channel, callOptions);
        }
      };
    return Service3BlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Service3FutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Service3FutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Service3FutureStub>() {
        @Override
        public Service3FutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Service3FutureStub(channel, callOptions);
        }
      };
    return Service3FutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class Service3ImplBase implements io.grpc.BindableService {

    /**
     */
    public void setReminder(Reminder request,
                            io.grpc.stub.StreamObserver<Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetReminderMethod(), responseObserver);
    }

    /**
     */
    public void getReminder(ReminderId request,
                            io.grpc.stub.StreamObserver<ResponseMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetReminderMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ReminderId> deleteReminder(
        io.grpc.stub.StreamObserver<ResponseMessage> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getDeleteReminderMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetReminderMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                Reminder,
                Response>(
                  this, METHODID_SET_REMINDER)))
          .addMethod(
            getGetReminderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ReminderId,
                ResponseMessage>(
                  this, METHODID_GET_REMINDER)))
          .addMethod(
            getDeleteReminderMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                ReminderId,
                ResponseMessage>(
                  this, METHODID_DELETE_REMINDER)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class Service3Stub extends io.grpc.stub.AbstractAsyncStub<Service3Stub> {
    private Service3Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Service3Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Service3Stub(channel, callOptions);
    }

    /**
     */
    public void setReminder(Reminder request,
                            io.grpc.stub.StreamObserver<Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSetReminderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReminder(ReminderId request,
                            io.grpc.stub.StreamObserver<ResponseMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReminderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ReminderId> deleteReminder(
        io.grpc.stub.StreamObserver<ResponseMessage> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getDeleteReminderMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class Service3BlockingStub extends io.grpc.stub.AbstractBlockingStub<Service3BlockingStub> {
    private Service3BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Service3BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Service3BlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<Response> setReminder(
        Reminder request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSetReminderMethod(), getCallOptions(), request);
    }

    /**
     */
    public ResponseMessage getReminder(ReminderId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReminderMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class Service3FutureStub extends io.grpc.stub.AbstractFutureStub<Service3FutureStub> {
    private Service3FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Service3FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Service3FutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ResponseMessage> getReminder(
        ReminderId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReminderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_REMINDER = 0;
  private static final int METHODID_GET_REMINDER = 1;
  private static final int METHODID_DELETE_REMINDER = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Service3ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Service3ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_REMINDER:
          serviceImpl.setReminder((Reminder) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_GET_REMINDER:
          serviceImpl.getReminder((ReminderId) request,
              (io.grpc.stub.StreamObserver<ResponseMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_DELETE_REMINDER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.deleteReminder(
              (io.grpc.stub.StreamObserver<ResponseMessage>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class Service3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Service3BaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Service3Impl.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Service3");
    }
  }

  private static final class Service3FileDescriptorSupplier
      extends Service3BaseDescriptorSupplier {
    Service3FileDescriptorSupplier() {}
  }

  private static final class Service3MethodDescriptorSupplier
      extends Service3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Service3MethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (Service3Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Service3FileDescriptorSupplier())
              .addMethod(getSetReminderMethod())
              .addMethod(getGetReminderMethod())
              .addMethod(getDeleteReminderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
