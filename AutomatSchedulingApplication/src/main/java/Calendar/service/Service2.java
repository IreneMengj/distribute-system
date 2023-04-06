package Calendar.service;

import Login.ds.service1.RequestMessage;
import Login.ds.service1.ResponseMessage;
import Login.ds.service1.Service1Grpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.HashMap;

public class Service2 extends Service1Grpc.Service1ImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
        Service2 service1 = new Service2();

        int port = 50051;

        Server server = ServerBuilder.forPort(port)
                .addService(service1)
                .build()
                .start();

        System.out.println("Service-1 started, listening on " + port);


        server.awaitTermination();
    }

    //create a map to save username and password
    HashMap<String, String> map = new HashMap<String, String>();


    @Override
    public void login(RequestMessage request, StreamObserver<ResponseMessage> responseObserver) {
        map.put("irene", "123456");

        String username = request.getUsername();
        String password = request.getPassword();
        ResponseMessage reply;

        //preparing the response message
        if ("irene".equals(username) && "123456".equals(password)) {
            reply = ResponseMessage.newBuilder().setCode(1).build();
        } else {
            reply = ResponseMessage.newBuilder().setCode(0).build();
        }
        responseObserver.onNext(reply);

        responseObserver.onCompleted();
    }

    @Override
    public void signup(RequestMessage request, StreamObserver<ResponseMessage> responseObserver) {
        map.put("irene", "123456");
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

        responseObserver.onCompleted();


    }
}
