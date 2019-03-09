package com.rdittmann.grpc.channel;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

@Component
public class Channel {

    private static final ManagedChannel MANAGED_CHANNEL = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

    public static ManagedChannel getManagedChannel() {
        return MANAGED_CHANNEL;
    }
}
