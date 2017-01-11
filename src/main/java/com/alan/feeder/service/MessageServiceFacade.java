package com.alan.feeder.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by aleh on 12/8/16.
 */
@Service("messageServiceFacade")
@Slf4j
public class MessageServiceFacade implements MessageService {

    @Value("${queue.use}")
    public String useQueue;

    @Autowired
    private MessageService mailMessageService;

    @Autowired
    private MessageService redisQueueService;

    @Override
    public void sendMessage(Object obj) throws Exception {
        log.debug(">>> Sent " + new Date() + obj);
        if (Boolean.TRUE.equals(useQueue)) {
            redisQueueService.sendMessage(obj);
        } else {
            mailMessageService.sendMessage(obj);
        }
    }
}
