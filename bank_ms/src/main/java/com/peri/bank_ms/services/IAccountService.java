package com.peri.bank_ms.services;

import com.peri.bank_ms.dto.BankAccountRequestDTO;
import com.peri.bank_ms.dto.BankAccountResponseDTO;

public interface IAccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccount);
}