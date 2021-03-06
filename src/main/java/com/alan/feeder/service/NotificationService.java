package com.alan.feeder.service;

import com.alan.feeder.model.google.PushNotificationsCredentials;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

/**
 * TODO: implement FCM instead of GCM
 * Created by aleh on 1/19/17.
 */
@Service
@Profile("dev")
@Slf4j
public class NotificationService implements MessageService<PushNotificationsCredentials> {

    private final static String GCM_API_KEY = "GCM_API_KEY";

    private final static int retries = 3;

    @Override
    public void sendMessage(PushNotificationsCredentials obj) throws Exception {
        Objects.nonNull(obj);
        Sender sender = new Sender(GCM_API_KEY);
        Message msg = new Message.Builder().addData("message", obj.getMessage()).build();
        String gcmRegId = obj.getGcmRegId();
        try {
            if (gcmRegId != null) {
                Result result = sender.send(msg, gcmRegId, retries);
                if (StringUtils.isEmpty(result.getErrorCodeName())) {
                    log.debug("GCM Notification is sent successfully" + result.toString());
                }
                else {
                    log.debug("Error occurred while sending push notification :" + result.getErrorCodeName());
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}