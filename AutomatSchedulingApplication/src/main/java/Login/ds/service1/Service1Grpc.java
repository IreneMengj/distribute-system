package Login.ds.service1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: service1.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class Service1Grpc {

  private Service1Grpc() {}

  public static final String SERVICE_NAME = "service1.Service1";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<RequestMessage,
      ResponseMessage> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = RequestMessage.class,
      responseType = ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<RequestMessage,
      ResponseMessage> getLoginMethod() {
    io.grpc.MethodDescriptor<RequestMessage, ResponseMessage> getLoginMethod;
    if ((getLoginMethod = Service1Grpc.getLoginMethod) == null) {
      synchronized (Service1Grpc.class) {
        if ((getLoginMethod = Service1Grpc.getLoginMethod) == null) {
          Service1Grpc.getLoginMethod = getLoginMethod =
              io.grpc.MethodDescriptor.<RequestMessage, ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RequestMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ResponseMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Service1MethodDescriptorSupplier("login"))
              .build();
        }
      }
    }
    return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RequestMessage,
      ResponseMessage> getSignupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "signup",
      requestType = RequestMessage.class,
      responseType = ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<RequestMessage,
      ResponseMessage> getSignupMethod() {
    io.grpc.MethodDescriptor<RequestMessage, ResponseMessage> getSignupMethod;
    if ((getSignupMethod = Service1Grpc.getSignupMethod) == null) {
      synchronized (Service1Grpc.class) {
        if ((getSignupMethod = Service1Grpc.getSignupMethod) == null) {
          Service1Grpc.getSignupMethod = getSignupMethod =
              io.grpc.MethodDescriptor.<RequestMessage, ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "signup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RequestMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ResponseMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Service1MethodDescriptorSupplier("signup"))
              .build();
        }
      }
    }
    return getSignupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ResponseMessage> getIsLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "isLogin",
      requestType = com.google.protobuf.Empty.class,
      responseType = ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      ResponseMessage> getIsLoginMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, ResponseMessage> getIsLoginMethod;
    if ((getIsLoginMethod = Service1Grpc.getIsLoginMethod) == null) {
      synchronized (Service1Grpc.class) {
        if ((getIsLoginMethod = Service1Grpc.getIsLoginMethod) == null) {
          Service1Grpc.getIsLoginMethod = getIsLoginMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "isLogin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ResponseMessage.getDefaultInstance()))
              .setSchemaDescriptor(new Service1MethodDescriptorSupplier("isLogin"))
              .build();
        }
      }
    }
    return getIsLoginMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Service1Stub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Service1Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Service1Stub>() {
        @Override
        public Service1Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Service1Stub(channel, callOptions);
        }
      };
    return Service1Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Service1BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Service1BlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Service1BlockingStub>() {
        @Override
        public Service1BlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Service1BlockingStub(channel, callOptions);
        }
      };
    return Service1BlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Service1FutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<Service1FutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<Service1FutureStub>() {
        @Override
        public Service1FutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new Service1FutureStub(channel, callOptions);
        }
      };
    return Service1FutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class Service1ImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<RequestMessage> login(
        io.grpc.stub.StreamObserver<ResponseMessage> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<RequestMessage> signup(
        io.grpc.stub.StreamObserver<ResponseMessage> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSignupMethod(), responseObserver);
    }

    /**
     */
    public void isLogin(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ResponseMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIsLoginMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                RequestMessage,
                ResponseMessage>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getSignupMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                RequestMessage,
                ResponseMessage>(
                  this, METHODID_SIGNUP)))
          .addMethod(
            getIsLoginMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                ResponseMessage>(
                  this, METHODID_IS_LOGIN)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class Service1Stub extends io.grpc.stub.AbstractAsyncStub<Service1Stub> {
    private Service1Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Service1Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Service1Stub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<RequestMessage> login(
        io.grpc.stub.StreamObserver<ResponseMessage> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<RequestMessage> signup(
        io.grpc.stub.StreamObserver<ResponseMessage> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSignupMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void isLogin(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<ResponseMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIsLoginMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class Service1BlockingStub extends io.grpc.stub.AbstractBlockingStub<Service1BlockingStub> {
    private Service1BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Service1BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Service1BlockingStub(channel, callOptions);
    }

    /**
     */
    public ResponseMessage isLogin(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIsLoginMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class Service1FutureStub extends io.grpc.stub.AbstractFutureStub<Service1FutureStub> {
    private Service1FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected Service1FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new Service1FutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ResponseMessage> isLogin(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIsLoginMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_IS_LOGIN = 0;
  private static final int METHODID_LOGIN = 1;
  private static final int METHODID_SIGNUP = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Service1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Service1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_IS_LOGIN:
          serviceImpl.isLogin((com.google.protobuf.Empty) request,
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
        case METHODID_LOGIN:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.login(
              (io.grpc.stub.StreamObserver<ResponseMessage>) responseObserver);
        case METHODID_SIGNUP:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.signup(
              (io.grpc.stub.StreamObserver<ResponseMessage>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class Service1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Service1BaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Service1Impl.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Service1");
    }
  }

  private static final class Service1FileDescriptorSupplier
      extends Service1BaseDescriptorSupplier {
    Service1FileDescriptorSupplier() {}
  }

  private static final class Service1MethodDescriptorSupplier
      extends Service1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Service1MethodDescriptorSupplier(String methodName) {
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
      synchronized (Service1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Service1FileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getSignupMethod())
              .addMethod(getIsLoginMethod())
              .build();
        }
      }
    }
    return result;
  }
}
