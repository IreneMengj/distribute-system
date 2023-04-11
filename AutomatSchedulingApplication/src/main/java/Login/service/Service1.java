package Login.service;

import Login.ds.service1.RequestMessage;
import Login.ds.service1.ResponseMessage;
import Login.ds.service1.Service1Grpc;
import com.google.common.base.Strings;
import com.google.protobuf.Empty;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

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


    //create a map to save username and password
    private static HashMap<String, String> map = new HashMap<String, String>();
    private static Boolean flag = false;

    @Override
    public void login(RequestMessage request, StreamObserver<ResponseMessage> responseObserver) {
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
        responseObserver.onCompleted();
    }

    @Override
    public void signup(RequestMessage request, StreamObserver<ResponseMessage> responseObserver) {
//        map.put("irene", "123456");
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
