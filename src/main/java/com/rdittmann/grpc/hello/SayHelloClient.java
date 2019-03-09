package com.rdittmann.grpc.hello;

import com.rdittmann.grpc.channel.Channel;
import com.rdittmann.grpc.hello.Person;
import com.rdittmann.grpc.hello.SayHelloServiceGrpc;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SayHelloClient {

    private SayHelloServiceGrpc.SayHelloServiceBlockingStub sayHelloService;


    @PostConstruct
    private void init() {
        sayHelloService = SayHelloServiceGrpc.newBlockingStub(Channel.getManagedChannel());
    }

    public String hi(final String name, final String surname) {
        return sayHelloService.hi(Person.newBuilder().setName(name).setSurname(surname).build()).getMessage();
    }

}
