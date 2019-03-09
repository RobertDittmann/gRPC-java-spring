package com.rdittmann.grpc.math;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class SomeMathOperationServiceImpl extends SomeMathOperationServiceGrpc.SomeMathOperationServiceImplBase {

    @Override
    public void sum(final Values request, final StreamObserver<Result> responseObserver) {
        responseObserver.onNext(Result.newBuilder()
                .setResult(request.getValueList().stream().mapToInt(value -> value).sum()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void multiply(final Values request, final StreamObserver<Result> responseObserver) {
        responseObserver.onNext(Result.newBuilder()
                .setResult(request.getValueList().stream().mapToInt(value -> value)
                        .reduce(1, Math::multiplyExact)).build());
        responseObserver.onCompleted();
    }
}
