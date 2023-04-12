package Calendar.ds.service2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: service2.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class Service2Grpc {

  private Service2Grpc() {}

  public static final String SERVICE_NAME = "service2.Service2";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Appointment,
      Response> getAddEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addEvent",
      requestType = Appointment.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<Appointment,
      Response> getAddEventMethod() {
    io.grpc.MethodDescriptor<Appointment, Response> getAddEventMethod;
    if ((getAddEventMethod = Service2Grpc.getAddEventMethod) == null) {
      synchronized (Service2Grpc.class) {
        if ((getAddEventMethod = Service2Grpc.getAddEventMethod) == null) {
          Service2Grpc.getAddEventMethod = getAddEventMethod =
              io.grpc.MethodDescriptor.<Appointment, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Appointment.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
              .setSchemaDescriptor(new Service2MethodDescriptorSupplier("addEvent"))
              .build();
        }
      }
    }
    return getAddEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<eventId,
      ResponseMessage> getDeleteEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteEvent",
      requestType = eventId.class,
      responseType = ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<eventId,
      ResponseMessage> getDeleteEventMethod() {
    io.grpc.MethodDescriptor<eventId, ResponseMessage> getDeleteEventMethod;
    if ((getDeleteEventMethod = Service2Grpc.getDeleteEventMethod) == null) {
      synchronized (Service2Grpc.class) {
        if ((getDeleteEventMethod = Service2Grpc.getDeleteEventMethod) == null) {
          Service2Grpc.getDeleteEventMethod = getDeleteEventMethod =
              io.grpc.MethodDescriptor.<eventId, ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  eventId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ResponseMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Service2MethodDescriptorSupplier("deleteEvent"))
              .build();
        }
      }
    }
    return getDeleteEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Appointment,
      ResponseMessage> getUpdateEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateEvent",
      requestType = Appointment.class,
      responseType = ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Appointment,
      ResponseMessage> getUpdateEventMethod() {
    io.grpc.MethodDescriptor<Appointment, ResponseMessage> getUpdateEventMethod;
    if ((getUpdateEventMethod = Service2Grpc.getUpdateEventMethod) == null) {
      synchronized (Service2Grpc.class) {
        if ((getUpdateEventMethod = Service2Grpc.getUpdateEventMethod) == null) {
          Service2Grpc.getUpdateEventMethod = getUpdateEventMethod =
              io.grpc.MethodDescriptor.<Appointment, ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Appointment.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ResponseMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Service2MethodDescriptorSupplier("updateEvent"))
              .build();
        }
      }
    }
    return getUpdateEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      Appointment> getGetEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getEvents",
      requestType = com.google.protobuf.Empty.class,
      responseType = Appointment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      Appointment> getGetEventsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, Appointment> getGetEventsMethod;
    if ((getGetEventsMethod = Service2Grpc.getGetEventsMethod) == null) {
      synchronized (Service2Grpc.class) {
        if ((getGetEventsMethod = Service2Grpc.getGetEventsMethod) == null) {
          Service2Grpc.getGetEventsMethod = getGetEventsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, Appointment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getEvents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Appointment.getDefaultInstance()))
              .setSchemaDescriptor(new Service2MethodDescriptorSupplier("getEvents"))
              .build();
        }
      }
    }
    return getGetEventsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Service2Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Service2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Service2Stub>() {
        @Override
        public Service2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Service2Stub(channel, callOptions);
        }
      };
    return Service2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Service2BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Service2BlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Service2BlockingStub>() {
        @Override
        public Service2BlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Service2BlockingStub(channel, callOptions);
        }
      };
    return Service2BlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Service2FutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Service2FutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Service2FutureStub>() {
        @Override
        public Service2FutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Service2FutureStub(channel, callOptions);
        }
      };
    return Service2FutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class Service2ImplBase implements io.grpc.BindableService {

    /**
     */
    public void addEvent(Appointment request,
                         io.grpc.stub.StreamObserver<Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddEventMethod(), responseObserver);
    }

    /**
     */
    public void deleteEvent(eventId request,
                            io.grpc.stub.StreamObserver<ResponseMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteEventMethod(), responseObserver);
    }

    /**
     */
    public void updateEvent(Appointment request,
                            io.grpc.stub.StreamObserver<ResponseMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateEventMethod(), responseObserver);
    }

    /**
     */
    public void getEvents(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<Appointment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEventsMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddEventMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                Appointment,
                Response>(
                  this, METHODID_ADD_EVENT)))
          .addMethod(
            getDeleteEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                eventId,
                ResponseMessage>(
                  this, METHODID_DELETE_EVENT)))
          .addMethod(
            getUpdateEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Appointment,
                ResponseMessage>(
                  this, METHODID_UPDATE_EVENT)))
          .addMethod(
            getGetEventsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                Appointment>(
                  this, METHODID_GET_EVENTS)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class Service2Stub extends io.grpc.stub.AbstractAsyncStub<Service2Stub> {
    private Service2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Service2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Service2Stub(channel, callOptions);
    }

    /**
     */
    public void addEvent(Appointment request,
                         io.grpc.stub.StreamObserver<Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getAddEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteEvent(eventId request,
                            io.grpc.stub.StreamObserver<ResponseMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateEvent(Appointment request,
                            io.grpc.stub.StreamObserver<ResponseMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getEvents(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<Appointment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetEventsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class Service2BlockingStub extends io.grpc.stub.AbstractBlockingStub<Service2BlockingStub> {
    private Service2BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Service2BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Service2BlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<Response> addEvent(
        Appointment request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getAddEventMethod(), getCallOptions(), request);
    }

    /**
     */
    public ResponseMessage deleteEvent(eventId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEventMethod(), getCallOptions(), request);
    }

    /**
     */
    public ResponseMessage updateEvent(Appointment request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEventMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<Appointment> getEvents(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetEventsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class Service2FutureStub extends io.grpc.stub.AbstractFutureStub<Service2FutureStub> {
    private Service2FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Service2FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Service2FutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ResponseMessage> deleteEvent(
        eventId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEventMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ResponseMessage> updateEvent(
        Appointment request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEventMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_EVENT = 0;
  private static final int METHODID_DELETE_EVENT = 1;
  private static final int METHODID_UPDATE_EVENT = 2;
  private static final int METHODID_GET_EVENTS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Service2ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Service2ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_EVENT:
          serviceImpl.addEvent((Appointment) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_DELETE_EVENT:
          serviceImpl.deleteEvent((eventId) request,
              (io.grpc.stub.StreamObserver<ResponseMessage>) responseObserver);
          break;
        case METHODID_UPDATE_EVENT:
          serviceImpl.updateEvent((Appointment) request,
              (io.grpc.stub.StreamObserver<ResponseMessage>) responseObserver);
          break;
        case METHODID_GET_EVENTS:
          serviceImpl.getEvents((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<Appointment>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class Service2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Service2BaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Service2Impl.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Service2");
    }
  }

  private static final class Service2FileDescriptorSupplier
      extends Service2BaseDescriptorSupplier {
    Service2FileDescriptorSupplier() {}
  }

  private static final class Service2MethodDescriptorSupplier
      extends Service2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Service2MethodDescriptorSupplier(String methodName) {
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
      synchronized (Service2Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Service2FileDescriptorSupplier())
              .addMethod(getAddEventMethod())
              .addMethod(getDeleteEventMethod())
              .addMethod(getUpdateEventMethod())
              .addMethod(getGetEventsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
