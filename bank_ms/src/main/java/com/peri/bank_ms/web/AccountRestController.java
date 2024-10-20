package com.peri.bank_ms.web;

import com.peri.bank_ms.dto.BankAccountRequestDTO;
import com.peri.bank_ms.dto.BankAccountResponseDTO;
import com.peri.bank_ms.entities.BankAccount;
import com.peri.bank_ms.enums.AccountType;
import com.peri.bank_ms.repositories.BankAccountRepository;
import com.peri.bank_ms.services.AccountServiceImpl;
import com.peri.bank_ms.services.IAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AccountRestController {
    private BankAccountRepository bankAccountRepo;
    private IAccountService accountService;

    AccountRestController(BankAccountRepository bankAccountRepo, IAccountService accountService) {
        this.bankAccountRepo = bankAccountRepo;
        this.accountService = accountService;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> getBankAccounts() {
        return bankAccountRepo.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount getBankAccount(@PathVariable  String id) {
        return bankAccountRepo.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(String.format("Account not found (id = %s)", id))
                );
    }

    @PostMapping("/bankAccount")
    public BankAccountResponseDTO saveAccount(@RequestBody BankAccountRequestDTO bankAccount) {
        return accountService.addAccount(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount updateAccount(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount account = bankAccountRepo.findById(id).orElseThrow();

        if (account.getCurrency() != null)
            account.setCurrency(bankAccount.getCurrency());
        if (account.getBalance() != null)
            account.setBalance(bankAccount.getBalance());
        if (account.getType() != null)
            account.setType(bankAccount.getType());

        return bankAccountRepo.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
        bankAccountRepo.deleteById(id);
    }


}