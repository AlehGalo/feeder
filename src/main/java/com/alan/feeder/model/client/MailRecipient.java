package com.alan.feeder.model.client;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by aleh on 1/5/17.
 */
@Data
public class MailRecipient {

    @NotNull
    private String mailAddress, firstName, lastName;

    private String id;
}
