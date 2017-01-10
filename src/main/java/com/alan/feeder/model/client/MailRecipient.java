package com.alan.feeder.model.client;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by aleh_bahatyrou on 1/5/17.
 */
@Data
public class MailRecipient {

    @NotNull
    private String mailAddress;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String id;
}
