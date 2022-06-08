package by.sak.dormitory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.SpringServletContainerInitializer;

@SpringBootApplication
public class DormitoryApplication extends SpringServletContainerInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DormitoryApplication.class, args);
    }

}
