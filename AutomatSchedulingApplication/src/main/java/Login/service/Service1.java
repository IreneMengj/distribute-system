package Login.service;

import Login.ds.service1.RequestMessage;
import Login.ds.service1.ResponseMessage;
import Login.ds.service1.Service1Grpc;


import com.google.protobuf.Empty;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class Service1 extends Service1Grpc.Service1ImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
        // Start gRPC server
        // Register service with JmDNS
        JmDNS jmdns = JmDNS.create();
        ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "service1", 50051, "");
        jmdns.registerService(serviceInfo);

        Service1 service1 = new Service1();
        Server server;
        try {
            server = ServerBuilder.forPort(50051).addService(service1).build().start();
            System.out.println("Service-1 started, listening on " + 50051);
            server.awaitTermination();
        } catch (Exception e) {
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
                    if(username.length()<8||password.length()<8){
                        reply = ResponseMessage.newBuilder().setCode(2).build();
                    }else if (!password.matches(".*[A-Z].*") || !password.matches(".*[a-z].*")
                            || !password.matches(".*\\W.*") || !password.matches(".*\\d.*")) {
                        reply = ResponseMessage.newBuilder().setCode(3).build();
                    } else{
                    map.put(username, password);
                    reply = ResponseMessage.newBuilder().setCode(1).build();}
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
                    if (status.getCode() == Status.Code.CANCELLED) {
                        JOptionPane.showMessageDialog(null,
                                "The request was cancelled.");}
                    else if (status.getCode() == Status.Code.DEADLINE_EXCEEDED) {
                        responseObserver.onError(Status.DEADLINE_EXCEEDED.
                                withDescription("Request deadline exceeded").asRuntimeException());
                    } else if (status.getCode() == Status.Code.UNAUTHENTICATED) {
                        responseObserver.onError(Status.UNAUTHENTICATED.
                                withDescription("Unauthenticated request").asRuntimeException());
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
        try {
            ResponseMessage reply;
            if (flag) {
                reply = ResponseMessage.newBuilder().setCode(1).build();
            } else {
                reply = ResponseMessage.newBuilder().setCode(0).build();
            }
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (StatusRuntimeException e) {
            // Handle exception related to deadlines, metadata, or authentication
            Status status = e.getStatus();
            if (status.getCode() == Status.Code.CANCELLED) {
                JOptionPane.showMessageDialog(null, "The request was cancelled.");
            } else if (status.getCode() == Status.Code.DEADLINE_EXCEEDED) {
                responseObserver.onError(Status.DEADLINE_EXCEEDED.withDescription("Request deadline exceeded").asRuntimeException());
            } else if (status.getCode() == Status.Code.UNAUTHENTICATED) {
                responseObserver.onError(Status.UNAUTHENTICATED.withDescription("Unauthenticated request").asRuntimeException());
            } else {
                responseObserver.onError(e);
            }
        }

    }
}
