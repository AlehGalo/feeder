package com.alan.feeder.repository;

import com.alan.feeder.model.client.MailRecipient;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by aleh_bahatyrou on 1/5/17.
 */
public interface MailRecipientRepository extends MongoRepository<MailRecipient, String> {
}
