package com.alan.feeder.service;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * Created by aleh_bahatyrou on 12/2/16.
 */
@Slf4j
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(Object message) {
        log.debug("Received <" + message + ">");
        log.debug("Received <" + message.getClass() + " > " + (message instanceof ArrayList));
        if(message instanceof ArrayList){
            ArrayList list = (ArrayList)message;
            System.out.println(list.size());
            for (Object obj: list) {
                System.out.println(obj);
            }
        }
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
