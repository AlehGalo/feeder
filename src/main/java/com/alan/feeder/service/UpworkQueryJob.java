package com.alan.feeder.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by aleh_bahatyrou on 12/1/16.
 */
@Service
@Slf4j
public class UpworkQueryJob {

    public static final String CRON_JOB_STARTED = "Cron job started";
    @Autowired
    private UpworkService upworkService;

    @Value("${job.query}")
    private String queryString;

    @Scheduled(cron = "${job.cron}")
    public void queryNewJobs() {
        log.debug(CRON_JOB_STARTED);
        System.out.println(CRON_JOB_STARTED);
        upworkService.getJobs(queryString);
    }
}
