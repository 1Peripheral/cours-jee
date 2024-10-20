package com.peri.bank_ms.services;

import com.peri.bank_ms.dto.BankAccountRequestDTO;
import com.peri.bank_ms.dto.BankAccountResponseDTO;
import com.peri.bank_ms.entities.BankAccount;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IAccountService {
    public BankAccountResponseDTO get(String id);
    public List<BankAccountResponseDTO> getAll();
    public BankAccountResponseDTO add(BankAccountRequestDTO bankAccount);
    public void delete(String id);
    public BankAccountResponseDTO update(String id, BankAccountRequestDTO bankAccount);
}