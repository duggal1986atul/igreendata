package com.au.igreendata.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.au.igreendata.model.Account;
import com.au.igreendata.model.Transaction;
import com.au.igreendata.service.BankAccountService;

@RestController
public class BankAccountController {

    private final Logger             logger = LoggerFactory.getLogger(BankAccountController.class);
    private final BankAccountService accountService;

    public BankAccountController(final BankAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * This service fetches all accounts.
     *
     * @return Accounts List as JSON.
     */
    @GetMapping(path = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Account>> getAllAccounts() {
        logger.info("AccountController.getAllAccounts");
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    /**
     * This service fetches all transactions for an account.
     *
     * @return Transactions List as JSON.
     */
    @GetMapping(path = "/accounts/{accountNumber}/transactions")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable final Long accountNumber) {
        logger.info("AccountController.getTransactions");
        return new ResponseEntity<>(accountService.findAccountTrans(accountNumber), HttpStatus.OK);
    }
}
