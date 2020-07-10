package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.repository"})
public class SensorsReportStartPoint {


    public static void main(String... args) {
        SpringApplication.run(SensorsReportStartPoint.class, args);
    }

}
