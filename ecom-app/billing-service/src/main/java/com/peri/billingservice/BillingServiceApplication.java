package com.peri.billingservice;

import com.peri.billingservice.entities.Bill;
import com.peri.billingservice.entities.ProductItem;
import com.peri.billingservice.feign.CustomerRestClient;
import com.peri.billingservice.feign.ProductRestClient;
import com.peri.billingservice.models.Customer;
import com.peri.billingservice.models.Product;
import com.peri.billingservice.repositories.BillRepository;
import com.peri.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient
                                        ){
        return args -> {
            Collection<Customer> customers = customerRestClient.getCustomers().getContent();
            Collection<Product> products = productRestClient.getProducts().getContent();

            customers.forEach(customer -> {
                Bill bill;
                bill = Bill.builder()
                        .billDate(new Date())
                        .customerId(customer.getId())
                        .build();
                billRepository.save(bill);
                products.forEach(product -> {
                    ProductItem productItem = ProductItem.builder()
                            .bill(bill)
                            .productId(product.getId())
                            .quantity(1+new Random().nextInt(10))
                            .price(product.getPrice())
                            .build();
                    productItemRepository.save(productItem);
                });
            });
        };
    }
}
