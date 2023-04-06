package Calendar.service;

import Calendar.ds.service2.Appointment;
import Calendar.ds.service2.Service2Grpc;
import Login.ds.service1.RequestMessage;
import Login.ds.service1.ResponseMessage;
import Login.ds.service1.Service1Grpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Service2 extends Service2Grpc.Service2ImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
        Service2 service2 = new Service2();

        int port = 50052;

        Server server = ServerBuilder.forPort(port)
                .addService(service2)
                .build()
                .start();

        System.out.println("Service-2 started, listening on " + port);


        server.awaitTermination();
    }

    //create a map to save username and password
    List<Appointment> list = new ArrayList<>();

    @Override
    public void addEvent(Appointment request, StreamObserver<Calendar.ds.service2.ResponseMessage> responseObserver) {
        int id=request.getId();
        String title = request.getTitle();
        String paticipant = request.getParticipants();
        String desc=request.getDetail();
        String time=request.getOccurTime();
        Appointment appointment =new Appointment(id,title,desc,time,paticipant);
        list.add(appointment);


    }

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
