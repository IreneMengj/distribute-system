package Calendar.service;

import Calendar.ds.service2.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service2 extends Service2Grpc.Service2ImplBase {
    public static void main(String[] args) throws InterruptedException, IOException {
        // Register service with JmDNS
        JmDNS jmdns = JmDNS.create();
        ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "service2", 50052, "");
        jmdns.registerService(serviceInfo);
        // Start gRPC server
        Service2 service2 = new Service2();

        Server server = ServerBuilder.forPort(serviceInfo.getPort())
                .addService(service2)
                .build()
                .start();

        System.out.println("Service-2 started, listening on " + serviceInfo.getPort());
        server.awaitTermination();
    }

    //create a map to save username and password
    List<Appointment.Builder> list = new ArrayList<>();

    @Override
    public void addEvent(Appointment request, StreamObserver<Calendar.ds.service2.ResponseMessage> responseObserver) {
//        System.out.println(list.get(0).getId());
        int id=request.getId();
        String title = request.getTitle();
        String paticipant = request.getParticipants();
        String desc=request.getDetail();
        String time=request.getOccurTime();
        Appointment appointment =new Appointment();
        Appointment.Builder builder = appointment.toBuilder().setId(id).setTitle(title).setDetail(desc).setOccurTime(time).setParticipants(paticipant
        );
        Calendar.ds.service2.ResponseMessage reply;
        list.add(builder);
        if (title.equals("")) {
            reply=Calendar.ds.service2.ResponseMessage.newBuilder().setCode(0).build();
        } else {
            reply=Calendar.ds.service2.ResponseMessage.newBuilder().setCode(1).setAppointments(0,builder).build();
        }
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void updateEvent(Appointment request, StreamObserver<Calendar.ds.service2.ResponseMessage> responseObserver) {

    }

    @Override
    public void deleteEvent(eventId request, StreamObserver<Calendar.ds.service2.ResponseMessage> responseObserver) {

        int id = request.getId();
        boolean flag=false;
        for(Appointment.Builder a:list){
            if(a.getId()==id){
                 flag= list.remove(a);
                 break;
            }
        }
        Calendar.ds.service2.ResponseMessage reply;
        if(flag) {
            reply = Calendar.ds.service2.ResponseMessage.newBuilder().setCode(1).build();
        }else{
            reply = Calendar.ds.service2.ResponseMessage.newBuilder().setCode(0).build();
        }
        responseObserver.onNext(reply);
        responseObserver.onCompleted();

    }

    @Override
    public void viewEvent(eventIdList request, StreamObserver<AppointmentRequest> responseObserver) {

    }
}
