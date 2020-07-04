package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableMongoRepositories(repositoryBaseClass = TestObjectRepository.class)
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }
}
