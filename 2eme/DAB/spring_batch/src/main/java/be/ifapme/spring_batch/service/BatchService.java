package be.ifapme.spring_batch.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class BatchService {

    private final JobLauncher jobLauncher;
    private final Job importUserJob;

    public BatchService(JobLauncher jobLauncher, Job importUserJob) {
        this.jobLauncher = jobLauncher;
        this.importUserJob = importUserJob;
    }

    public void runJob() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("inputFile", "classpath:personnes-csv.csv")
                .addDate("timestamp", new Date())
                .toJobParameters();

        jobLauncher.run(importUserJob, jobParameters);
    }
}
