package com.alan.feeder.model.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by aleh_bahatyrou on 1/5/17.
 */
@Data
@ConfigurationProperties("mailConfig")
@Component
public class MailDefaults {

    private String defaultFrom;

    private String subject;

}