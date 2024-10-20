package com.peri.bank_ms;

import com.peri.bank_ms.entities.BankAccount;
import com.peri.bank_ms.enums.AccountType;
import com.peri.bank_ms.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankMsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepo) {
        return args -> {
            for (int i = 0 ; i < 10 ; i++) {
                BankAccount bankAccount = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .balance(Math.random() * 100_000)
                        .type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
                        .createdAt(new Date())
                        .currency("MAD")
                        .build();
                bankAccountRepo.save(bankAccount);
            }
        };
    }
}
