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
    public List<BankAccountResponseDTO> getBankAccounts() {
        return accountService.getAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO getBankAccount(@PathVariable  String id) {
        return accountService.get(id);
    }

    @PostMapping("/bankAccount")
    public BankAccountResponseDTO saveAccount(@RequestBody BankAccountRequestDTO bankAccount) {
        return accountService.add(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO updateAccount(@PathVariable String id, @RequestBody BankAccountRequestDTO bankAccount) {
        return accountService.update(id, bankAccount);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
        accountService.delete(id);
    }
}