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
  private static volatile io.grpc.MethodDescriptor<Calendar.ds.service2.AppointmentRequest,
          Calendar.ds.service2.ResponseMessage> getAddEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addEvent",
      requestType = Calendar.ds.service2.AppointmentRequest.class,
      responseType = Calendar.ds.service2.ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Calendar.ds.service2.AppointmentRequest,
          Calendar.ds.service2.ResponseMessage> getAddEventMethod() {
    io.grpc.MethodDescriptor<Calendar.ds.service2.AppointmentRequest, Calendar.ds.service2.ResponseMessage> getAddEventMethod;
    if ((getAddEventMethod = Service2Grpc.getAddEventMethod) == null) {
      synchronized (Service2Grpc.class) {
        if ((getAddEventMethod = Service2Grpc.getAddEventMethod) == null) {
          Service2Grpc.getAddEventMethod = getAddEventMethod =
              io.grpc.MethodDescriptor.<Calendar.ds.service2.AppointmentRequest, Calendar.ds.service2.ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Calendar.ds.service2.AppointmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Calendar.ds.service2.ResponseMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Service2MethodDescriptorSupplier("addEvent"))
              .build();
        }
      }
    }
    return getAddEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Calendar.ds.service2.eventId,
          Calendar.ds.service2.ResponseMessage> getDeleteEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteEvent",
      requestType = Calendar.ds.service2.eventId.class,
      responseType = Calendar.ds.service2.ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Calendar.ds.service2.eventId,
          Calendar.ds.service2.ResponseMessage> getDeleteEventMethod() {
    io.grpc.MethodDescriptor<Calendar.ds.service2.eventId, Calendar.ds.service2.ResponseMessage> getDeleteEventMethod;
    if ((getDeleteEventMethod = Service2Grpc.getDeleteEventMethod) == null) {
      synchronized (Service2Grpc.class) {
        if ((getDeleteEventMethod = Service2Grpc.getDeleteEventMethod) == null) {
          Service2Grpc.getDeleteEventMethod = getDeleteEventMethod =
              io.grpc.MethodDescriptor.<Calendar.ds.service2.eventId, Calendar.ds.service2.ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Calendar.ds.service2.eventId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Calendar.ds.service2.ResponseMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Service2MethodDescriptorSupplier("deleteEvent"))
              .build();
        }
      }
    }
    return getDeleteEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Calendar.ds.service2.eventIdList,
          Calendar.ds.service2.AppointmentRequest> getUpdateEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateEvent",
      requestType = Calendar.ds.service2.eventIdList.class,
      responseType = Calendar.ds.service2.AppointmentRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Calendar.ds.service2.eventIdList,
          Calendar.ds.service2.AppointmentRequest> getUpdateEventMethod() {
    io.grpc.MethodDescriptor<Calendar.ds.service2.eventIdList, Calendar.ds.service2.AppointmentRequest> getUpdateEventMethod;
    if ((getUpdateEventMethod = Service2Grpc.getUpdateEventMethod) == null) {
      synchronized (Service2Grpc.class) {
        if ((getUpdateEventMethod = Service2Grpc.getUpdateEventMethod) == null) {
          Service2Grpc.getUpdateEventMethod = getUpdateEventMethod =
              io.grpc.MethodDescriptor.<Calendar.ds.service2.eventIdList, Calendar.ds.service2.AppointmentRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateEvent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Calendar.ds.service2.eventIdList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Calendar.ds.service2.AppointmentRequest.getDefaultInstance()))
              .setSchemaDescriptor(new Service2MethodDescriptorSupplier("updateEvent"))
              .build();
        }
      }
    }
    return getUpdateEventMethod;
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
    public void addEvent(Calendar.ds.service2.AppointmentRequest request,
                         io.grpc.stub.StreamObserver<Calendar.ds.service2.ResponseMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddEventMethod(), responseObserver);
    }

    /**
     */
    public void deleteEvent(Calendar.ds.service2.eventId request,
                            io.grpc.stub.StreamObserver<Calendar.ds.service2.ResponseMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteEventMethod(), responseObserver);
    }

    /**
     */
    public void updateEvent(Calendar.ds.service2.eventIdList request,
                            io.grpc.stub.StreamObserver<Calendar.ds.service2.AppointmentRequest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateEventMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                      Calendar.ds.service2.AppointmentRequest,
                      Calendar.ds.service2.ResponseMessage>(
                  this, METHODID_ADD_EVENT)))
          .addMethod(
            getDeleteEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                      Calendar.ds.service2.eventId,
                      Calendar.ds.service2.ResponseMessage>(
                  this, METHODID_DELETE_EVENT)))
          .addMethod(
            getUpdateEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                      Calendar.ds.service2.eventIdList,
                      Calendar.ds.service2.AppointmentRequest>(
                  this, METHODID_UPDATE_EVENT)))
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
    public void addEvent(Calendar.ds.service2.AppointmentRequest request,
                         io.grpc.stub.StreamObserver<Calendar.ds.service2.ResponseMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteEvent(Calendar.ds.service2.eventId request,
                            io.grpc.stub.StreamObserver<Calendar.ds.service2.ResponseMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateEvent(Calendar.ds.service2.eventIdList request,
                            io.grpc.stub.StreamObserver<Calendar.ds.service2.AppointmentRequest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEventMethod(), getCallOptions()), request, responseObserver);
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
    public Calendar.ds.service2.ResponseMessage addEvent(Calendar.ds.service2.AppointmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddEventMethod(), getCallOptions(), request);
    }

    /**
     */
    public Calendar.ds.service2.ResponseMessage deleteEvent(Calendar.ds.service2.eventId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEventMethod(), getCallOptions(), request);
    }

    /**
     */
    public Calendar.ds.service2.AppointmentRequest updateEvent(Calendar.ds.service2.eventIdList request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEventMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<Calendar.ds.service2.ResponseMessage> addEvent(
        Calendar.ds.service2.AppointmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddEventMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Calendar.ds.service2.ResponseMessage> deleteEvent(
        Calendar.ds.service2.eventId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEventMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Calendar.ds.service2.AppointmentRequest> updateEvent(
        Calendar.ds.service2.eventIdList request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEventMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_EVENT = 0;
  private static final int METHODID_DELETE_EVENT = 1;
  private static final int METHODID_UPDATE_EVENT = 2;

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
          serviceImpl.addEvent((Calendar.ds.service2.AppointmentRequest) request,
              (io.grpc.stub.StreamObserver<Calendar.ds.service2.ResponseMessage>) responseObserver);
          break;
        case METHODID_DELETE_EVENT:
          serviceImpl.deleteEvent((eventId) request,
              (io.grpc.stub.StreamObserver<ResponseMessage>) responseObserver);
          break;
        case METHODID_UPDATE_EVENT:
          serviceImpl.updateEvent((eventIdList) request,
              (io.grpc.stub.StreamObserver<AppointmentRequest>) responseObserver);
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
              .build();
        }
      }
    }
    return result;
  }
}
