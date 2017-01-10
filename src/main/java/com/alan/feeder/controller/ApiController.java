package com.alan.feeder.controller;

import com.alan.feeder.model.config.ServerConfig;
import com.alan.feeder.model.settings.MailDefaults;
import com.alan.feeder.service.MailMessageService;
import com.alan.feeder.service.UpworkApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aleh_bahatyrou on 12/9/16.
 */
@RestController
public class ApiController {

    @Autowired
    private UpworkApiService service;

    @Autowired
    private MailMessageService mailMessageService;

    @Autowired
    private MailDefaults mailDefaults;

    @PutMapping(value = "/api/config")
    public String setUpCredentials(@RequestBody ServerConfig config) {
        mailDefaults.setDefaultFrom(config.getUsername());
        mailMessageService.initConfig(config);
        return service.initSecretAndToken(config);
    }

}
