package com.cyber_chill.scheduler;

//import com.cyber_chill.entity.Reserve;
//import com.cyber_chill.repositories.ReserveRepository;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.repository.support.SimpleJobRepository;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Map;

//@Configuration
//@EnableBatchProcessing
//@EnableScheduling
public class FeeJobConfig {

//    private final JobBuilderFactory jobBuilderFactory;
//    private final StepBuilderFactory stepBuilderFactory;
//    private final JobLauncher jobLauncher;
//
//    @Autowired
//    public FeeJobConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, JobLauncher jobLauncher) {
//        this.jobBuilderFactory = jobBuilderFactory;
//        this.stepBuilderFactory = stepBuilderFactory;
//        this.jobLauncher = jobLauncher;
//    }
//
//    @Bean
//    @StepScope
//    public ItemReader<Reserve> feeReader(ReserveRepository reserveRepository) {
//        return new RepositoryItemReaderBuilder<Reserve>()
//                .name("feeItemReader")
//                .repository(reserveRepository)
//                .methodName("findAll")
//                .sorts(Map.of("id", Sort.Direction.ASC))
//                .maxItemCount(100) // Adjust as needed
//                .saveState(false)
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public ItemProcessor<Reserve, Reserve> feeProcessor() {
//        return reserve -> {
//            double newReservationPrice = reserve.getPrice() * 1.05; // Increase fee by 10%
//            reserve.setPrice(newReservationPrice);
//            return reserve;
//        };
//    }
//
//    @Bean
//    @StepScope
//    public ItemWriter<Reserve> feeWriter(ReserveRepository reserveRepository) {
//        return items -> {
//            reserveRepository.saveAll(items);
//        };
//    }
//
//    @Bean
//    public Step feeStep(ItemReader<Reserve> feeReader, ItemProcessor<Reserve, Reserve> feeProcessor, ItemWriter<Reserve> feeWriter) {
//        return stepBuilderFactory.get("feeStep")
//                .<Reserve, Reserve>chunk(10) // обробляє 10 резервацій за раз
//                .reader(feeReader)
//                .processor(feeProcessor)
//                .writer(feeWriter)
//                .build();
//    }
//
//    @Bean
//    public Job feeJob(Step feeStep) {
//        return jobBuilderFactory.get("feeJob")
//                .incrementer(new RunIdIncrementer())
//                .flow(feeStep)
//                .end()
//                .build();
//    }
//
//    // Виконується раз на рік
//    @Scheduled(cron = "0 0 1 1 1 *")
//    public void runFeeJob() throws Exception {
//        jobLauncher.run(feeJob(null), null);
//    }
}
