package com.example.numbers_batch.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BatchService {

    private final JobLauncher jobLauncher;
    private final Job importNumberJob;

    public BatchService(JobLauncher jobLauncher, Job importNumberJob) {
        this.jobLauncher = jobLauncher;
        this.importNumberJob = importNumberJob;
    }

    public void runJob() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("inputFile", "classpath:numbers-result.csv")
                .addDate("timestamp", new Date())
                .toJobParameters();

        jobLauncher.run(importNumberJob, jobParameters);
    }
}
