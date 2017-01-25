package com.alan.feeder.service;

import com.alan.feeder.model.google.PushNotificationsCredentials;
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

    public static final String GCM_KEY = "APA91bF4DLICAnsh8aIC3cJaUEabFntEmIG2BEMLRvfBolyfchUeR4zA0oSFzuJBFO2gIEmULScTLNhpWvKP0vius5PxFfeC-IdC3evkXj7UslS-27KEE1GG2Qxp8QOR8_7c5GvKDegW";
    public static final String MESSAGE = "Hi There message";
    @Value("${queue.use}")
    public String useQueue;

    @Value("${push.use}")
    public String usePush;


    @Autowired
    private MessageService mailMessageService;

    @Autowired
    private MessageService redisQueueService;

    @Autowired
    private MessageService<PushNotificationsCredentials> notificationService;

    @Override
    public void sendMessage(Object obj) throws Exception {
        log.debug(">>> Sent " + new Date() + obj);
        if (Boolean.TRUE.equals(useQueue)) {
            redisQueueService.sendMessage(obj);
        } else {
            mailMessageService.sendMessage(obj);
        }

        if(Boolean.TRUE.toString().equalsIgnoreCase(usePush)){
            notificationService.sendMessage(new PushNotificationsCredentials(GCM_KEY, MESSAGE));
        }
    }
}
