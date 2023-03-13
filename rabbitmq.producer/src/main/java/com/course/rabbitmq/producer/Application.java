package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.producer.HelloRabbitProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.UUID;

@SpringBootApplication
@EnableScheduling
public class Application implements CommandLineRunner {

    //private final HelloRabbitProducer producer;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //producer.sendHello("Hello Shine! " + UUID.randomUUID());
    }
}
