package com.example.numbers_batch;

import com.example.numbers_batch.service.BatchService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NumbersBatchApplication {

    private final BatchService batchService;

    public NumbersBatchApplication(BatchService batchService) {
        this.batchService = batchService;
    }

    public static void main(String[] args) {
        SpringApplication.run(NumbersBatchApplication.class, args);
    }

    @PostConstruct
    public void run() throws Exception {
        batchService.runJob();
    }

}
