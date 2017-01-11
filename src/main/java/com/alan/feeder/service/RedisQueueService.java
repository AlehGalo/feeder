package com.alan.feeder.service;

import com.alan.feeder.config.MessageQueueConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by aleh on 12/6/16.
 */
@Service("redisQueueService")
public class RedisQueueService implements MessageService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void sendMessage(Object obj) throws Exception {
        redisTemplate.convertAndSend(MessageQueueConfiguration.queueName, obj);
    }
}
