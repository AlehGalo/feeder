package com.alan.feeder.service;

import com.alan.feeder.model.google.PushNotificationsCredentials;
import com.alan.feeder.model.upwork.Job;
import com.alan.feeder.model.upwork.JobRequest;
import com.alan.feeder.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by aleh on 11/23/16.
 */
@Service
@Slf4j
public class UpworkService {

    private static final int REQUEST_PAGE_COUNT = 10;


    private Set<String> idsUsedSet = new HashSet<>();

    @Autowired
    private UpworkApiService upworkApiService;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private MessageService messageServiceFacade;


    @Autowired
    private MessageService<PushNotificationsCredentials> notificationService;

    public String getJobs(String query) {
        try {
            int offset = 0, count = REQUEST_PAGE_COUNT;
            long total = -1;
            boolean makeNextQuery = true;
            JobRequest jobRequest = null;
            while (makeNextQuery) {
                jobRequest = upworkApiService.sendRequestToApi(REQUEST_PAGE_COUNT, offset, query);
                if (CollectionUtils.isEmpty(jobRequest.getJobs())) {
                    makeNextQuery = false;
                }
                else {
                    if (total < 0) {
                        total = jobRequest.getPaging().getTotal();
                    }
                    makeNextQuery = offset + count < total;
                    offset += REQUEST_PAGE_COUNT;
                    count = Math.min(REQUEST_PAGE_COUNT, ((int) total - offset));
                    List<Job> list = getNewJobs(jobRequest.getJobs());
                    if (!list.isEmpty()) {
                        jobRepository.save(list);
                        try {
                            messageServiceFacade.sendMessage(list.stream().map(a -> a.getUrl()).collect(Collectors.joining(
                                    " \n ")));
                        }
                        catch (Exception e) {
                            log.error(e.getMessage(), e);
                        }
                    }
                    else {
                        makeNextQuery = false;
                    }
                }
            }
            return jobRequest.toString();
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    @PostConstruct
    private void initCache() {
        idsUsedSet.addAll(jobRepository.findAll().stream().map(Job::getId).collect(Collectors.toList()));
    }

    private List<Job> getNewJobs(Iterable<Job> jobs) {
        long start = System.nanoTime();
        List<Job> iterable = StreamSupport.stream(jobs.spliterator(), false).
                filter(a -> (!idsUsedSet.contains(a.getId()))).collect(Collectors.toList());
        log.debug(System.nanoTime() - start + " ns " + iterable.spliterator().getExactSizeIfKnown());
        idsUsedSet.addAll(iterable.stream().map(Job::getId).collect(Collectors.toList()));
        return iterable;
    }
}