package com.peri.customerservice;

import com.peri.customerservice.entities.Customer;
import com.peri.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
                                               RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);
            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("Bob").email("bob@gmail.com").build(),
                            Customer.builder().name("John").email("john@gmail.com").build(),
                            Customer.builder().name("Jane").email("jane@gmail.com").build()
                    )
            );
            customerRepository.findAll().forEach(System.out::println);
        };
    }

}
