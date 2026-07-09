package com.github.hofls;

import com.github.hofls.protobuf.GreeterGrpc;
import com.github.hofls.protobuf.HelloWorldProto;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GreeterClient {

    @GrpcClient("greeter")
    private GreeterGrpc.GreeterBlockingStub blockingStub;

    public void sayHello(String name) {
        HelloWorldProto.HelloRequest request = HelloWorldProto.HelloRequest.newBuilder().setName(name).build();
        HelloWorldProto.HelloResponse response = blockingStub.sayHello(request);
        System.out.println("Response from server: " + response.getMessage());
    }
}

