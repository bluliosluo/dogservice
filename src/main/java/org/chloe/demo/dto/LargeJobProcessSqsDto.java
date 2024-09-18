package org.chloe.demo.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableLargeJobProcessSqsDto.class)
@JsonDeserialize(as = ImmutableLargeJobProcessSqsDto.class)
public interface LargeJobProcessSqsDto {
    String getJobId();
    String getS3Key();
}

// Compare this snippet from src/main/java/org/abx/demo883b2bbe/sqs/MessageProcessor.java:
// Compare this snippet from src/main/java/org/abx/demo883b2bbe/sqs/SqsProducer.java: