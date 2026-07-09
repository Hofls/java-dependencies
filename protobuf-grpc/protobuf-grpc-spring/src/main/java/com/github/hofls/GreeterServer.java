package com.github.hofls;

import com.github.hofls.protobuf.GreeterGrpc;
import com.github.hofls.protobuf.HelloWorldProto;
import net.devh.boot.grpc.server.service.GrpcService;
import io.grpc.stub.StreamObserver;

@GrpcService
public class GreeterServer extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloWorldProto.HelloRequest req, StreamObserver<HelloWorldProto.HelloResponse> responseObserver) {
        System.out.println("Server received a request!");
        HelloWorldProto.HelloResponse reply = HelloWorldProto.HelloResponse.newBuilder().setMessage("Hello " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}

