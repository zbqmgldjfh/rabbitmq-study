package com.course.rabbitmq.producer.producer;

import com.course.rabbitmq.producer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJsonProducer {

    private final RabbitTemplate rabbitTemplate;

    private final ObjectMapper objectMapper;

    public EmployeeJsonProducer(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(Employee employee) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(employee);

        rabbitTemplate.convertAndSend("shine.employee", json);
    }
}
