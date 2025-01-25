package be.ifapme.spring_batch;

import be.ifapme.spring_batch.service.BatchService;
import jakarta.annotation.PostConstruct;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBatchApplication {

    private final BatchService batchService;

    public SpringBatchApplication(BatchService batchService) {
        this.batchService = batchService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchApplication.class, args);
    }

    @PostConstruct
    public void run() throws Exception {
        batchService.runJob();
    }
}
