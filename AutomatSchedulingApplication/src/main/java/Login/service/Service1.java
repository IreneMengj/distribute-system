package Login.service;

import Login.ds.service1.RequestMessage;
import Login.ds.service1.ResponseMessage;
import Login.ds.service1.Service1Grpc;

import com.google.protobuf.Empty;
import com.sun.tools.javadoc.Start;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Set;

public class Service1 extends Service1Grpc.Service1ImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
//        // Register service with JmDNS
//        JmDNS jmdns = JmDNS.create();
//        ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "service1", 50051, "");
//        jmdns.registerService(serviceInfo);
////       Start gRPC server
//        Service1 service1 = new Service1();
//
//        int port = 50051;
//
//        Server server = ServerBuilder.forPort(port)
//                .addService(service1)
//                .build()
//                .start();
//
//        System.out.println("Service-1 started, listening on " + 50051);
//
//
//        server.awaitTermination();
        try {
            // 创建jmDNS实例
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // 创建ServiceInfo对象
            ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "service1", 50051, "");

            // 注册服务
            jmdns.registerService(serviceInfo);
            System.out.println("Service-1 started, listening on " + 50051);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //create a map to save username and password
    private static HashMap<String, String> map = new HashMap<String, String>();
    private static Boolean flag = false;

    @Override
    public StreamObserver<RequestMessage> login(StreamObserver<ResponseMessage> responseObserver) {
        StreamObserver<RequestMessage> requestObserver = new StreamObserver<RequestMessage>() {
            @Override
            public void onNext(RequestMessage request) {
                String username = request.getUsername();
                String password = request.getPassword();
                ResponseMessage reply = null;

                //preparing the response message
                if (map.size() > 0) {
                    Set<String> strings = map.keySet();
                    for (String s : strings) {
                        if (s.equals(username) && map.get(s).equals(password)) {

                            reply = ResponseMessage.newBuilder().setCode(1).build();
                            flag = true;

                        } else {
                            reply = ResponseMessage.newBuilder().setCode(2).build();
                        }
                    }

                } else {
                    reply = ResponseMessage.newBuilder().setCode(0).build();
                }
                responseObserver.onNext(reply);
            }

            @Override
            public void onError(Throwable t) {

                if (t instanceof StatusRuntimeException) {
                    StatusRuntimeException e = (StatusRuntimeException) t;
                    Status status = e.getStatus();
                    if (status.getCode() == Status.Code.DEADLINE_EXCEEDED) {
                        responseObserver.onError(Status.DEADLINE_EXCEEDED.withDescription("Request deadline exceeded").asRuntimeException());
                    } else if (status.getCode() == Status.Code.UNAUTHENTICATED) {
                        responseObserver.onError(Status.UNAUTHENTICATED.withDescription("Unauthenticated request").asRuntimeException());
                    } else {
                        responseObserver.onError(e);
                    }
                } else {
                    // Handle other exceptions
                    responseObserver.onError(t);
                }
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }


        };
        return requestObserver;
    }


    @Override
    public StreamObserver<RequestMessage> signup(StreamObserver<ResponseMessage> responseObserver) {
        StreamObserver<RequestMessage> requestObserver = new StreamObserver<RequestMessage>() {
            @Override
            public void onNext(RequestMessage request) {

                String username = request.getUsername();
                String password = request.getPassword();
                ResponseMessage reply;
                //preparing the response message
                if (!map.containsKey(username)) {
                    map.put(username, password);
                    reply = ResponseMessage.newBuilder().setCode(1).build();
                } else {
                    reply = ResponseMessage.newBuilder().setCode(0).build();
                }
                responseObserver.onNext(reply);

            }

            @Override
            public void onError(Throwable t) {
                if (t instanceof StatusRuntimeException) {
                    StatusRuntimeException e = (StatusRuntimeException) t;
                    Status status = e.getStatus();
                    if (status.getCode() == Status.Code.DEADLINE_EXCEEDED) {
                        responseObserver.onError(Status.DEADLINE_EXCEEDED.withDescription("Request deadline exceeded").asRuntimeException());
                    } else if (status.getCode() == Status.Code.UNAUTHENTICATED) {
                        responseObserver.onError(Status.UNAUTHENTICATED.withDescription("Unauthenticated request").asRuntimeException());
                    } else {
                        responseObserver.onError(e);
                    }
                } else {
                    // Handle other exceptions
                    responseObserver.onError(t);
                }
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
        return requestObserver;
    }


    @Override
    public void isLogin(Empty request, StreamObserver<ResponseMessage> responseObserver) {
        ResponseMessage reply;
        if (flag) {
            reply = ResponseMessage.newBuilder().setCode(1).build();
        } else {
            reply = ResponseMessage.newBuilder().setCode(0).build();
        }
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
