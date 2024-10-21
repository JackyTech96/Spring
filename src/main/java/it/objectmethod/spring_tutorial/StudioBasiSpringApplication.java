package it.objectmethod.spring_tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudioBasiSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudioBasiSpringApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner stampaBean(ApplicationContext ctx) {
//        return args -> {
//            System.out.println("Bean creati da Spring Boot:");
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            for (String beanName : beanNames) {
//                System.out.printf("Bean ---> %s\n", beanName);
//            }
//        };
//    }

}
