package com.peri.bank_ms.web;

import com.peri.bank_ms.dto.BankAccountResponseDTO;
import com.peri.bank_ms.repositories.BankAccountRepository;
import com.peri.bank_ms.services.IAccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGQLController {
    private BankAccountRepository bankAccountRepo;
    private IAccountService accountService;

    public BankAccountGQLController(BankAccountRepository bankAccountRepo, IAccountService accountService) {
        this.bankAccountRepo = bankAccountRepo;
        this.accountService = accountService;
    }

    @QueryMapping
    public List<BankAccountResponseDTO> accountList() {
       return accountService.getAll();
    }

    @QueryMapping
    public BankAccountResponseDTO accountById(@Argument String id) {
        return accountService.get(id);
    }
}
