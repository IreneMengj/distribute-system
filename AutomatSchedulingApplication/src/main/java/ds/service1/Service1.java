package ds.service1;

import java.io.IOException;

import ds.service1.Service1Grpc.Service1ImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class Service1 extends Service1ImplBase{



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
		String username="irene";
		String password="123456";
		//prepare the value to be set back
//		int length = request.getText().length();
		String text = request.getText();
		String[] s = text.split(" ");
		//preparing the response message
		ResponseMessage reply=null;
		if("irene".equals(s[0])&&"123456".equals(s[1])){
			reply = ResponseMessage.newBuilder().setLength(1).build();

		}else{
			reply = ResponseMessage.newBuilder().setLength(0).build();
		}
		responseObserver.onNext( reply );

		responseObserver.onCompleted();

	}
}
