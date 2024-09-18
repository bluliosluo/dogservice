package org.chloe.demo.configuration;

import org.chloe.demo.sqs.JobMessageProcessor;
import org.chloe.demo.sqs.MessageProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MessageProcessorConfig {

    @Bean
    @Qualifier("jobMessageProcessor")
    public MessageProcessor messageProcessor() {
        return new JobMessageProcessor();
    }
}
