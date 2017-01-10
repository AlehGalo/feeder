package com.alan.feeder.controller;

import com.alan.feeder.service.UpworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aleh_bahatyrou on 11/23/16.
 */
@RestController
public class EventController {

    @Autowired
    private UpworkService upworkService;

    @GetMapping(value = "/events/all/{query}")
    public String findJob(@PathVariable String query) {
        return upworkService.getJobs(query);
    }
}
