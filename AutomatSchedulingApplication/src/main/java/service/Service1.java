package service;

import ds.service1.RequestMessage;
import ds.service1.ResponseMessage;
import ds.service1.Service1Grpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Service1 extends Service1Grpc.Service1ImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
        Service1 service1 = new Service1();

        int port = 50051;

        Server server = ServerBuilder.forPort(port)
                .addService(service1)
                .build()
                .start();

        System.out.println("Service-1 started, listening on " + port);

        server.awaitTermination();
    }
    @Override
    public void service1Do(RequestMessage request, StreamObserver<ResponseMessage> responseObserver) {
        //create a map to save username and password
        HashMap<String,Integer> map=new HashMap<String, Integer>();
        map.put("irene",123456);

        String username = request.getUsername();
        String password = request.getPassword();
        ResponseMessage reply;
        //preparing the response message
        if("irene".equals(username)&&"123456".equals(password)) {
            reply = ResponseMessage.newBuilder().setCode(1).build();
        }else{
            reply = ResponseMessage.newBuilder().setCode(0).build();
        }
        responseObserver.onNext( reply );

        responseObserver.onCompleted();
    }
}
