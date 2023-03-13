package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Employee;
import com.course.rabbitmq.producer.producer.EmployeeJsonProducer;
import com.course.rabbitmq.producer.producer.HelloRabbitProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private EmployeeJsonProducer jsonProducer;

    public Application(EmployeeJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i = 0; i < 5; i++) {
            jsonProducer.sendMessage(new Employee("id_" + i, "employee-" + i, LocalDate.now()));
        }
    }
}
