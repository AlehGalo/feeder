package com.alan.feeder.service;

import com.alan.feeder.config.MessageQueueConfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by aleh on 12/2/16.
 */
//@Service
public class MessageQueueService implements MessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(Object obj) throws Exception {
        rabbitTemplate.convertAndSend(MessageQueueConfiguration.queueName, obj);
    }
}
