package com.github.hofls;

import com.github.hofls.protobuf.GreeterGrpc;
import com.github.hofls.protobuf.HelloWorldProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreeterClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

        HelloWorldProto.HelloResponse response = stub.sayHello(HelloWorldProto.HelloRequest.newBuilder().setName("World").build());

        System.out.println("Greeting: " + response.getMessage());

        channel.shutdown();
    }
}
