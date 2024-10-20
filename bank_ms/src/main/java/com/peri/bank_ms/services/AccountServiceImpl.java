package com.peri.bank_ms.services;

import com.peri.bank_ms.dto.BankAccountRequestDTO;
import com.peri.bank_ms.dto.BankAccountResponseDTO;
import com.peri.bank_ms.entities.BankAccount;
import com.peri.bank_ms.mappers.AccountMapper;
import com.peri.bank_ms.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements IAccountService {
   private BankAccountRepository bankRepo;
   private AccountMapper accountMapper;

   public AccountServiceImpl(BankAccountRepository bankRepo, AccountMapper accountMapper) {
      this.bankRepo = bankRepo;
      this.accountMapper = accountMapper;
   }

   public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountReq) {
      BankAccount bankAccount = BankAccount.builder()
              .id(UUID.randomUUID().toString())
              .createdAt(new Date())
              .balance(bankAccountReq.getBalance())
              .type(bankAccountReq.getType())
              .currency(bankAccountReq.getCurrency())
              .build();

      bankAccount = bankRepo.save(bankAccount);

      return accountMapper.toBankAccountResponseDTO(bankAccount);
   }
}
