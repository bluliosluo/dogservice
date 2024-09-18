package org.chloe.demo.controller;

import org.chloe.demo.service.ProcessLargeFileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/large-file-service")
public class LargeFileServiceController {
    private final ProcessLargeFileService processLargeFileService;

    public LargeFileServiceController(ProcessLargeFileService processLargeFileService) {
        this.processLargeFileService = processLargeFileService;
    }

    @PostMapping("process")
    public ResponseEntity<String> processLargeFile() {
        // process large file
        processLargeFileService.processLargeFile("large-file.txt");
        return ResponseEntity.ok("Processing large file");
    }
}
