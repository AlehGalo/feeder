package com.alan.feeder.model.google;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by aleh on 1/19/17.
 */
@Data
@AllArgsConstructor
public class PushNotificationsCredentials {
    private String gcmRegId, message;
}
