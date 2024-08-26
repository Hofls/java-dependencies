package hofls.com.github;

import hofls.com.github.protobuf.GreeterGrpc;
import hofls.com.github.protobuf.HelloWorldProto;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class GreeterServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new GreeterImpl())
                .build();

        server.start();
        System.out.println("Server started, listening on " + 50051);
        server.awaitTermination();
    }

    static class GreeterImpl extends GreeterGrpc.GreeterImplBase {
        @Override
        public void sayHello(HelloWorldProto.HelloRequest req, StreamObserver<HelloWorldProto.HelloResponse> responseObserver) {
            System.out.println("Request received!");
            HelloWorldProto.HelloResponse reply = HelloWorldProto.HelloResponse.newBuilder().setMessage("Hello " + req.getName()).build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }
    }
}

