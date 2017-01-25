package com.alan.feeder.service;

/**
 * Created by aleh on 12/8/16.
 */
public interface MessageService<T> {

    void sendMessage(T obj) throws Exception;
}
