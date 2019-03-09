package com.rdittmann.grpc;

import com.rdittmann.grpc.hello.SayHelloClient;
import com.rdittmann.grpc.math.SomeMathOperationClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GrpcsampleApplicationTests {

    @Autowired
    private SomeMathOperationClient someMathOperationClient;

    @Autowired
    private SayHelloClient sayHelloClient;

    @Test
    public void testSum() {
        assertEquals(someMathOperationClient.sum(Arrays.asList(0, 5, 3)), Integer.valueOf(8));
        assertEquals(someMathOperationClient.sum(Arrays.asList(-2, 5, 3)), Integer.valueOf(6));

    }


    @Test
    public void testMultiply() {
        assertEquals(someMathOperationClient.multiply(Arrays.asList(0, 5, 3)), Integer.valueOf(0));
        assertEquals(someMathOperationClient.multiply(Arrays.asList(-2, 5, -3)), Integer.valueOf(30));
    }

    @Test
    public void testHi() {
        assertEquals(sayHelloClient.hi("Robert", "Dittmann"), "Hi Robert Dittmann");
    }
}

