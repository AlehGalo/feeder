package com.alan.feeder.service;

import com.Upwork.api.Config;
import com.Upwork.api.OAuthClient;
import com.Upwork.api.Routers.Jobs.Search;
import com.alan.feeder.model.config.ServerConfig;
import com.alan.feeder.model.upwork.JobRequest;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by aleh on 12/2/16.
 */
@Service
@Slf4j
public class UpworkApiService {

    public static final String TITLE = "title";
    public static final String PATTERN = "{0};{1}";
    public static final String PAGING = "paging";
    private OAuthClient client;

    public String initSecretAndToken(ServerConfig config) {
        try {
            Properties properties = new Properties();
            properties.setProperty("consumerKey", config.getConsKey());
            properties.setProperty("consumerSecret", config.getConSec());


            client = new OAuthClient(new Config(properties));
            String aToken = config.getToken(), aSecret = config.getSecret();
            // authorize application and get access token
            if (aToken == null || aSecret == null) {
                return "Not all details";
            }
            else {
                // set known access token-secret pair
                client.setTokenWithSecret(aToken, aSecret);
            }
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            return "error " + e.getMessage();
        }
        return "ok";
    }

    public JobRequest sendRequestToApi(int count, int offset, String query) throws JSONException {
        Search jobs = new Search(client);
        HashMap<String, String> params = new HashMap<>();
        params.put(TITLE, query);
        params.put(PAGING, MessageFormat.format(PATTERN, offset, count));
        String json = jobs.find(params).toString();
        return new Gson().fromJson(json, JobRequest.class);
    }
}
