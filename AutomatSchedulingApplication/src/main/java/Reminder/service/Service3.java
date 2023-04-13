package Reminder.service;


import Reminder.ds.service3.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

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
    public void setReminder(Reminder request, StreamObserver<Response> responseObserver) {
        try {
            Reminder r = new Reminder();
            r.toBuilder().setID(request.getID()).setYear(request.getYear()).setMonth(request.getMonth()).setDay(request.getDay()).setHour(request.getHour()).setMin(request.getMin()).setSec(request.getSec());
            boolean add = list.add(r);
            Response reply;
            if (add) {
                reply = Response.newBuilder().setCode(1).setMessage("Add successfully").build();
            } else {
                reply = Response.newBuilder().setCode(0).setMessage("Add unsuccessfully").build();
            }
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            // Handle exceptions and send error responses
            responseObserver.onError(e);
        }
    }

    @Override
    public StreamObserver<ReminderId> deleteReminder(StreamObserver<ResponseMessage> responseObserver) {
        StreamObserver<ReminderId> delete_successfully = new StreamObserver<ReminderId>() {
            @Override
            public void onNext(ReminderId request) {
                List<Integer> idList = request.getIDList();
                for (Integer i : idList) {
                    for (Reminder r : list) {
                        if (r.getID() == i) {
                            list.remove(r);
                        }
                    }
                }
                ResponseMessage reply = ResponseMessage.newBuilder().setMessage("Delete successfully").build();
                responseObserver.onNext(reply);
                responseObserver.onCompleted();
                responseObserver.onNext(reply);
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }


        };
        return delete_successfully;
    }

    @Override
    public void getReminder(ReminderId request, StreamObserver<ResponseMessage> responseObserver) {
       try{
           int id = request.getID(0);
           LocalDateTime reminderTime = null;
           for (Reminder r : list) {
               if (r.getID() == id) {
                   reminderTime = LocalDateTime.of(Integer.parseInt(r.getYear()), Integer.parseInt(r.getMonth()), Integer.parseInt(r.getDay()), Integer.parseInt(r.getHour()), Integer.parseInt(r.getMin()), Integer.parseInt(r.getSec())); // Set the time when the prompt is triggered
               }
           }
           LocalDateTime now = LocalDateTime.now();
           ResponseMessage reply;
           if (now.isAfter(reminderTime)) {
               reply = ResponseMessage.newBuilder().setMessage("It's time to do something!").build();
           } else {
               reply = ResponseMessage.newBuilder().setMessage("Not yet.").build();
           }
           responseObserver.onNext(reply);
           responseObserver.onCompleted();

        } catch (Exception e) {
            // Handle exceptions and send error responses
            responseObserver.onError(e);
        }
    }
}
