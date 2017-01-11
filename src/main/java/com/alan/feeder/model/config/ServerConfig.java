package com.alan.feeder.model.config;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by aleh on 1/5/17.
 */
@Getter
@Setter
public class ServerConfig {

    private String consKey;
    private String conSec;
    private String token;
    private String secret;

    //mail
    private String host;
    private String username;
    private String password;

}
