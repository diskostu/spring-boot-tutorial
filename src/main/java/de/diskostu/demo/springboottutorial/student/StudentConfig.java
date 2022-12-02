package de.diskostu.demo.springboottutorial.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;
import static java.time.Month.MAY;

@Configuration
public class StudentConfig {

    /**
     * Put some initial data into the database.
     */
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            final Student student1 = new Student(
                    "Hans",
                    "hans@gmx.com",
                    LocalDate.of(1960, JANUARY, 5)
            );
            final Student student2 = new Student(
                    "Peter",
                    "peter@gmx.com",
                    LocalDate.of(1977, MAY, 11)
            );

            repository.saveAll(List.of(student1, student2));
        };
    }
}
