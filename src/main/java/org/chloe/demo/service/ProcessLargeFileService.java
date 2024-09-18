package org.chloe.demo.service;


import java.util.List;
import java.util.UUID;
import org.chloe.demo.dto.ImmutableLargeJobProcessSqsDto;
import org.chloe.demo.sqs.SqsProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProcessLargeFileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessLargeFileService.class);
    private final SqsProducer sqsProducer;

    public ProcessLargeFileService(SqsProducer sqsProducer) {
        this.sqsProducer = sqsProducer;
    }

    public void processLargeFile(String filePath) {
        // Read the file and process it
        // chunk file and save to S3
        UUID jobId = UUID.randomUUID();
        LOGGER.info("Processing large file: {}", filePath);
        List<String> chunks = chunkAndSaveToS3(filePath);
        LOGGER.info("File chunked and saved to S3: {}", chunks);
        // send chunks to SQS
        chunks.forEach(chunkKey -> sqsProducer.sendMessage(
                ImmutableLargeJobProcessSqsDto.builder()
                        .jobId(jobId.toString())
                        .s3Key(chunkKey)
                        .build()
        ));
    }

    private List<String> chunkAndSaveToS3(String filePath) {
        return List.of("chunk1", "chunk2", "chunk3");
    }

}
