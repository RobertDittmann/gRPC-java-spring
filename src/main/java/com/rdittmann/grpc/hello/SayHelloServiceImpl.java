package com.rdittmann.grpc.hello;

import com.rdittmann.grpc.hello.Answer;
import com.rdittmann.grpc.hello.Person;
import com.rdittmann.grpc.hello.SayHelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class SayHelloServiceImpl extends SayHelloServiceGrpc.SayHelloServiceImplBase {

    @Override
    public void hi(final Person request, final StreamObserver<Answer> responseObserver) {
        final Answer answer = Answer.newBuilder().setMessage("Hi " + request.getName() + " " + request.getSurname()).build();
        responseObserver.onNext(answer);
        responseObserver.onCompleted();
    }
}
