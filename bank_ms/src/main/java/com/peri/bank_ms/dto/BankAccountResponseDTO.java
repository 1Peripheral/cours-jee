package com.peri.bank_ms.dto;

import com.peri.bank_ms.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {
    private String id;
    private Double balance;
    private String currency;
    private AccountType type;
    private Date createdAt;
}
