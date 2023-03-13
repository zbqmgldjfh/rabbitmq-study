package com.course.rabbitmq.producer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//@Service
public class FixedRateProducer {

    private static final Logger log = LoggerFactory.getLogger(FixedRateProducer.class);

    private final RabbitTemplate rabbitTemplate;

    private int num = 0;

    public FixedRateProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedRate = 500)
    public void sendMessage() {
        num++;
        log.info("Num is {}", num);
        rabbitTemplate.convertAndSend("shine.fixedrate", "Fixed Rate = " + num);
    }
}
