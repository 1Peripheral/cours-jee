package com.peri.bank_ms.entities;

import com.peri.bank_ms.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Builder @Data
public class BankAccount {
    @Id
    private String id;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private Date createdAt;
}
