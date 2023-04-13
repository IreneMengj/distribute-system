package Reminder.service;

import Calendar.ds.service2.*;
import Calendar.service.Service2;
import Reminder.ds.service3.Reminder;
import Reminder.ds.service3.ReminderId;
import Reminder.ds.service3.Service3Grpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service3 extends Service3Grpc.Service3ImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
        // Register service with JmDNS
        JmDNS jmdns = JmDNS.create();
        ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "service3", 50053, "");
        jmdns.registerService(serviceInfo);
        // Start gRPC server
        Service3 service3 = new Service3();

        Server server = ServerBuilder.forPort(serviceInfo.getPort())
                .addService(service3)
                .build()
                .start();

        System.out.println("Service-3 started, listening on " + serviceInfo.getPort());
        server.awaitTermination();
    }

    //create a map to save username and password
    ArrayList<Reminder> list = new ArrayList<Reminder>();

    @Override
    public void setReminder(Reminder request, StreamObserver<Reminder.ds.service3.Response> responseObserver) {
        try {

            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            // Handle exceptions and send error responses
            responseObserver.onError(e);
        }
    }

    @Override
    public StreamObserver<ReminderId> deleteReminder(StreamObserver<Reminder.ds.service3.ResponseMessage> responseObserver) {
        return super.deleteReminder(responseObserver);
    }

    @Override
    public void getReminder(ReminderId request, StreamObserver<Reminder.ds.service3.ResponseMessage> responseObserver) {
        try {
            List<Integer> idList = request.getIDList();
            int id;
            for(Integer i:idList){

            }
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            // Handle exceptions and send error responses
            responseObserver.onError(e);
        }
    }
}
