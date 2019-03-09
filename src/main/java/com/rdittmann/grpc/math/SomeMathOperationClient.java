package com.rdittmann.grpc.math;

import com.rdittmann.grpc.channel.Channel;
import com.rdittmann.grpc.math.Result;
import com.rdittmann.grpc.math.SomeMathOperationServiceGrpc;
import com.rdittmann.grpc.math.Values;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class SomeMathOperationClient {


    private SomeMathOperationServiceGrpc.SomeMathOperationServiceBlockingStub mathServiceBlockingStub;

    @PostConstruct
    private void init() {
        mathServiceBlockingStub = SomeMathOperationServiceGrpc.newBlockingStub(Channel.getManagedChannel());
    }

    public Integer sum(final List<Integer> values) {
        final Values ints = Values.newBuilder().addAllValue(values).build();

        final Result result = mathServiceBlockingStub.sum(ints);

        return result.getResult();
    }

    public Integer multiply(final List<Integer> values) {
        final Values ints = Values.newBuilder().addAllValue(values).build();
        final Result result = mathServiceBlockingStub.multiply(ints);
        return result.getResult();
    }

}
