package be.ifapme.spring_batch.config;

import be.ifapme.spring_batch.model.Personne;
import be.ifapme.spring_batch.model.UserCsv;
import be.ifapme.spring_batch.repositoty.PersonneRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

    @Bean
    public Job importUserJob(
            JobRepository jobRepository,
            Step step1
    ) {
        return new JobBuilder("importUserJob", jobRepository)
                .start(step1)
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemReader<UserCsv> reader() {
        String filePath = "C:\\Users\\j.michel\\IdeaProjects\\csvPoc\\personne_express\\persons.csv";

        Resource resource = new FileSystemResource(filePath);

        return new FlatFileItemReaderBuilder<UserCsv>()
                .name("userItemReader")
                .resource(resource)
                .delimited()
                .names("firstName", "lastName", "street", "streetNumber", "city",
                        "phone", "gender", "email", "job", "suffix", "phoneNumber")
                .targetType(UserCsv.class)
                .build();
    }

    @Bean
    public UserProcessor processor() {
        return new UserProcessor();
    }

    @Bean
    public RepositoryItemWriter<Personne> writer(PersonneRepository userRepository) {
        RepositoryItemWriter<Personne> writer = new RepositoryItemWriter<>();
        writer.setRepository(userRepository);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step1(
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager,
            RepositoryItemWriter<Personne> writer,
            FlatFileItemReader<UserCsv> reader
    ) {
        return new StepBuilder("step1", jobRepository)
                .<UserCsv, Personne>chunk(100, transactionManager)
                .reader(reader)
                .processor(processor())
                .writer(writer)
                .build();
    }

    public static class UserProcessor implements ItemProcessor<UserCsv, Personne> {
        @Override
        public Personne process(UserCsv userCsv) {
            Personne personne = new Personne(
                   userCsv.getLastName(),
                   userCsv.getFirstName(),
                   userCsv.getStreet(),
                   userCsv.getStreetNumber(),
                   userCsv.getCity(),
                   userCsv.getPhoneNumber(),
                   userCsv.getPhone(),
                   userCsv.getGender(),
                   userCsv.getEmail(),
                   userCsv.getJob(),
                   userCsv.getSuffix()
            );
            return personne;
        }
    }
}
