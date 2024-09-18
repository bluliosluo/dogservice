package org.chloe.demo.configuration;

import org.chloe.demo.sqs.SqsConsumer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import java.net.URI;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import org.chloe.demo.sqs.SqsProducer;
import  org.chloe.demo.sqs.MessageProcessor;


@Configuration
public class SqsClientConfiguration {

    @Bean
    @Qualifier("demo-queue-url")
    public String queueURL() {
        return "http://localhost:4566/000000000000/demo-queue";
    }


    @Bean(destroyMethod = "close")
    public SqsClient sqsClient() {
        return SqsClient.builder()
                .endpointOverride(URI.create("http://localhost:4566"))
                .credentialsProvider(
                        StaticCredentialsProvider.create(
                                AwsBasicCredentials.create("dummy-key", "dummy-secret")
                        )
                )
                .region(Region.US_EAST_1)
                .build();
    }

    @Bean
    public SqsConsumer sqsConsumer(SqsClient sqsClient,
                                   @Qualifier("demo-queue-url") String queueUrl,
                                   @Qualifier("jobMessageProcessor") MessageProcessor messageProcessor) {
        return new SqsConsumer(sqsClient, queueUrl, messageProcessor);
    }

    @Bean
    public SqsProducer sqsProducer(SqsClient sqsClient,
                                   @Qualifier("demo-queue-url") String queueUrl) {
        return new SqsProducer(sqsClient, queueUrl);
    }


}
