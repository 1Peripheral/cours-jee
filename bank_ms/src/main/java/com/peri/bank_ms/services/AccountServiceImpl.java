package com.peri.bank_ms.services;

import com.peri.bank_ms.dto.BankAccountRequestDTO;
import com.peri.bank_ms.dto.BankAccountResponseDTO;
import com.peri.bank_ms.entities.BankAccount;
import com.peri.bank_ms.mappers.AccountMapper;
import com.peri.bank_ms.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountServiceImpl implements IAccountService {
   private BankAccountRepository bankRepo;
   private AccountMapper accountMapper;

   public AccountServiceImpl(BankAccountRepository bankRepo, AccountMapper accountMapper) {
      this.bankRepo = bankRepo;
      this.accountMapper = accountMapper;
   }

   public BankAccountResponseDTO add(BankAccountRequestDTO bankAccountReq) {
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

   public List<BankAccountResponseDTO> getAll() {
      List<BankAccount> bankAccounts = bankRepo.findAll();
      return bankAccounts.stream()
              .map(account -> accountMapper.toBankAccountResponseDTO(account))
              .toList();
   }

   public BankAccountResponseDTO get(String id) {
      BankAccount account = bankRepo.findById(id).orElseThrow();

      return accountMapper.toBankAccountResponseDTO(account);
   }

   public BankAccountResponseDTO update(String id, BankAccountRequestDTO bankAccount) {
      BankAccount account = bankRepo.findById(id).orElseThrow(
              () -> new RuntimeException(String.format("Account not found (id = %s)", id))
      );

      if (account.getCurrency() != null)
         account.setCurrency(bankAccount.getCurrency());
      if (account.getBalance() != null)
         account.setBalance(bankAccount.getBalance());
      if (account.getType() != null)
         account.setType(bankAccount.getType());

      return accountMapper.toBankAccountResponseDTO(
              bankRepo.save(account));
   }

   public void delete(String id) {
      bankRepo.deleteById(id);
   }
}
