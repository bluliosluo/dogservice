package org.chloe.demo.sqs;

import org.chloe.demo.dto.LargeJobProcessSqsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

public class SqsProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SqsProducer.class);
    private final SqsClient sqsClient;
    private final String queueUrl;

    public SqsProducer(SqsClient sqsClient, String queueUrl) {
        this.sqsClient = sqsClient;
        this.queueUrl = queueUrl;
    }

    public void sendMessage(LargeJobProcessSqsDto largeJobProcessSqsDto) {
        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(largeJobProcessSqsDto.toString())
                .build();
        try {
            sqsClient.sendMessage(sendMessageRequest);
        } catch (Exception e) {
            LOGGER.error("Failed to send message", e);
        }
    }

}