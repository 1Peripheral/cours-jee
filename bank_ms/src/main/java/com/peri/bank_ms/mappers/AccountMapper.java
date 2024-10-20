package com.peri.bank_ms.mappers;

import com.peri.bank_ms.dto.BankAccountRequestDTO;
import com.peri.bank_ms.dto.BankAccountResponseDTO;
import com.peri.bank_ms.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO toBankAccountResponseDTO(BankAccount bankAccount) {
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);

        return bankAccountResponseDTO;
    }

    public BankAccountRequestDTO toBankAccountRequestDTO(BankAccount bankAccount) {
        BankAccountRequestDTO bankAccountRequestDTO = new BankAccountRequestDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountRequestDTO);

        return bankAccountRequestDTO;
    }
}
