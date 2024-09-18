package org.chloe.demo.sqs;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.services.sqs.model.Message;


public class JobMessageProcessor implements MessageProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobMessageProcessor.class);

    @Override
    public void processMessage(Message message) {
        LOGGER.info("Processing job message: {}", message.body());
    }

}
