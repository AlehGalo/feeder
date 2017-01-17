package com.alan.feeder.controller;

import com.alan.feeder.repository.JobRepository;
import com.alan.feeder.repository.MailRecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by aleh_bahatyrou on 1/17/17.
 */
@Controller
@RequestMapping("/")
public class UIController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private MailRecipientRepository mailRecipientRepository;

    @GetMapping("/abc")
    public ModelAndView listMongoDBProperties() {
        return new ModelAndView("index", "status", new Status(jobRepository.count(), mailRecipientRepository.count()));
    }

    private class Status {
        public long jobCount, mailCount;

        public Status(long jobCount, long mailCount) {
            this.jobCount = jobCount;
            this.mailCount = mailCount;
        }
    }
}
