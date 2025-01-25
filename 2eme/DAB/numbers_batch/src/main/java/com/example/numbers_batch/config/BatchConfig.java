package com.example.numbers_batch.config;

import com.example.numbers_batch.model.Number;
import com.example.numbers_batch.model.NumberCsv;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    @Bean
    public Job importNumberJob(
            JobRepository jobRepository,
            Step step1
    ) {
        return new JobBuilder("importNumberJob", jobRepository)
                .start(step1)
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemReader<NumberCsv> reader() {
        String filePath = "C:\\Users\\nicoc\\OneDrive\\Bureau\\Cours IFAPME\\2eme\\DAB\\numbers_batch\\src\\main\\resources\\numbers.csv";

        Resource resource = new FileSystemResource(filePath);

        return new FlatFileItemReaderBuilder<NumberCsv>()
                .name("numbersItemReader")
                .resource(resource)
                .delimited()
                .names("nbr1", "nbr2", "nbr3", "nbr4")
                .targetType(NumberCsv.class)
                .build();
    }

    @Bean
    public UserProcessor processor() {
        return new UserProcessor();
    }

    @Bean
    public FlatFileItemWriter<Number> writer() {
        FlatFileItemWriter<Number> writer = new FlatFileItemWriter<>();
        writer.setResource(new FileSystemResource("src/main/resources/results/numbers.txt"));
        writer.setAppendAllowed(false);
        writer.setLineAggregator(new LineAggregator<Number>() {
            @Override
            public String aggregate(Number item) {
                return item.getNbr1() + " + " + item.getNbr2() + " + " + item.getNbr3() + " + " + item.getNbr4() + " = " + item.getTotal();
            }
        });
        return writer;
    };

    @Bean
    public Step step1(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            FlatFileItemWriter<Number> writer,
            FlatFileItemReader<NumberCsv> reader
    ) {
        return new StepBuilder("step1", jobRepository)
                .<NumberCsv, Number>chunk(100, transactionManager)
                .reader(reader)
                .processor(processor())
                .writer(writer)
                .build();
    }

    public static class UserProcessor implements ItemProcessor<NumberCsv, Number> {
        @Override
        public Number process(NumberCsv userCsv) {
            return new Number(
                    userCsv.getNbr1(),
                    userCsv.getNbr2(),
                    userCsv.getNbr3(),
                    userCsv.getNbr4()
            );
        }
    }
}