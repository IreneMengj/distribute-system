package Reminder.service;


import Login.ds.service1.RequestMessage;
import Login.service.Service1;
import Reminder.ds.service3.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.*;
import java.io.IOException;
import java.net.InetAddress;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Service3 extends Service3Grpc.Service3ImplBase {
    //create a map to save username and password
    public static ArrayList<Reminder.Builder> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException, IOException {
        // Start gRPC server
        // Register service with JmDNS
        JmDNS jmdns = JmDNS.create();
        ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "service3", 50053, "");
        jmdns.registerService(serviceInfo);

        Service3 service3 = new Service3();
        Server server;
        try {
            server = ServerBuilder.forPort(50053).addService(service3).build().start();
            System.out.println("Service-3 started, listening on " + 50053);
            server.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public StreamObserver<Reminder> setReminder(StreamObserver<Response> responseObserver) {
        StreamObserver<Reminder> requestObserver = new StreamObserver<Reminder>() {
            @Override
            public void onNext(Reminder reminder) {
                Reminder r = new Reminder();
                Reminder.Builder builder = r.toBuilder().setID(reminder.getID()).setYear(reminder.getYear()).setMonth(reminder.getMonth()).setDay(reminder.getDay()).setHour(reminder.getHour()).setMin(reminder.getMin()).setSec(reminder.getSec());
                boolean add = Service3.list.add(builder);
                Response reply;
                if (add) {
                    reply = Response.newBuilder().setCode(1).setMessage("Add successfully").build();
                } else {
                    reply = Response.newBuilder().setCode(0).setMessage("Add unsuccessfully").build();
                }
                responseObserver.onNext(reply);

            }

            @Override
            public void onError(Throwable throwable) {
                if (throwable instanceof StatusRuntimeException) {
                    StatusRuntimeException e = (StatusRuntimeException) throwable;
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
                    responseObserver.onError(throwable);
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
    public void deleteReminder(ReminderId request, StreamObserver<ResponseMessage> responseObserver) {
        try {
            int id = request.getID(0);
            for (Reminder.Builder b : Service3.list) {
                int id1 = b.getID();
                if (id1 == id) {
                    Service3.list.remove(b);
                    ResponseMessage reply = ResponseMessage.newBuilder().setMessage("Delete successfully").build();
                    responseObserver.onNext(reply);
                    responseObserver.onCompleted();
                    return;
                }
            }

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


    @Override
    public void getReminder(ReminderId request, StreamObserver<ResponseMessage> responseObserver) {
        try {
            int id = request.getID(0);
            for (Reminder.Builder b : Service3.list) {
                int id1 = b.getID();
                if (id1 == id) {
                    String year = b.getYear();
                    String month = b.getMonth();
                    if (month.length() == 1) {
                        month = "0" + month;
                    }
                    String day = b.getDay();
                    String hour = b.getHour();
                    String min = b.getMin();
                    String sec = b.getSec();
                    if (sec.length() == 1) {
                        sec = "0" + sec;
                    }
                    String reminderTime = year + "-" + month + "-" + "03" + " " + hour + ":" + min + ":" + sec; // Set the time when the prompt is triggered
                    LocalDateTime now = LocalDateTime.now();
                    String format = "yyyy-MM-dd HH:mm:ss"; // Specifies the date-time format
                    LocalDateTime parse = LocalDateTime.parse(reminderTime, DateTimeFormatter.ofPattern(format));
                    ResponseMessage reply;
                    if (now.isAfter(parse)) {
                        reply = ResponseMessage.newBuilder().setMessage("This task is not now!").build();
                    } else {
                        reply = ResponseMessage.newBuilder().setMessage("It's time to do this task!").build();
                    }
                    responseObserver.onNext(reply);
                    responseObserver.onCompleted();

                }
            }
        } catch (StatusRuntimeException e) {
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
