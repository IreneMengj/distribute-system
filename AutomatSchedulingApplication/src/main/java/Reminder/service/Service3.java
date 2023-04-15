package Reminder.service;


import Reminder.ds.service3.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Service3 extends Service3Grpc.Service3ImplBase {
    //create a map to save username and password
    public static ArrayList<Reminder.Builder> list = new ArrayList<>();

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


    @Override
    public void setReminder(Reminder request, StreamObserver<Response> responseObserver) {
        try {
            Reminder r = new Reminder();
            Reminder.Builder builder = r.toBuilder().setID(request.getID()).setYear(request.getYear()).setMonth(request.getMonth()).setDay(request.getDay()).setHour(request.getHour()).setMin(request.getMin()).setSec(request.getSec());
            boolean add = Service3.list.add(builder);
            Response reply;
            if (add) {
                reply = Response.newBuilder().setCode(1).setMessage("Add successfully").build();
            } else {
                reply = Response.newBuilder().setCode(0).setMessage("Add unsuccessfully").build();
            }
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (StatusRuntimeException e) {
            // Handle exception related to deadlines, metadata, or authentication
            Status status = e.getStatus();
            if (status.getCode() == Status.Code.DEADLINE_EXCEEDED) {
                responseObserver.onError(Status.DEADLINE_EXCEEDED.withDescription("Request deadline exceeded").asRuntimeException());
            } else if (status.getCode() == Status.Code.UNAUTHENTICATED) {
                responseObserver.onError(Status.UNAUTHENTICATED.withDescription("Unauthenticated request").asRuntimeException());
            } else {
                responseObserver.onError(e);
            }
        }
    }

    @Override
    public StreamObserver<ReminderId> deleteReminder(StreamObserver<ResponseMessage> responseObserver) {
        StreamObserver<ReminderId> delete_successfully = new StreamObserver<ReminderId>() {
            @Override
            public void onNext(ReminderId request) {
                List<Integer> idList = request.getIDList();
                for (Integer i : idList) {
                    for (Reminder.Builder b : Service3.list) {
                        if (b.getID() == i) {
                            Service3.list.remove(b);
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
        return delete_successfully;
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
                    String format = "yyyy-MM-dd HH:mm:ss"; // 指定日期时间格式
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
            if (status.getCode() == Status.Code.DEADLINE_EXCEEDED) {
                responseObserver.onError(Status.DEADLINE_EXCEEDED.withDescription("Request deadline exceeded").asRuntimeException());
            } else if (status.getCode() == Status.Code.UNAUTHENTICATED) {
                responseObserver.onError(Status.UNAUTHENTICATED.withDescription("Unauthenticated request").asRuntimeException());
            } else {
                responseObserver.onError(e);
            }
        }
    }
}
