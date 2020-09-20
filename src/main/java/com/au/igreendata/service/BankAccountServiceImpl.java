package com.au.igreendata.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.au.igreendata.exception.ServiceException;
import com.au.igreendata.model.Account;
import com.au.igreendata.model.Transaction;
import com.au.igreendata.repository.AccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private final Logger            logger = LoggerFactory.getLogger(BankAccountServiceImpl.class);
    private final AccountRepository accountRepository;

    @Autowired
    public BankAccountServiceImpl(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAllAccounts() {
        logger.info("AccountServiceImpl.getAllAccounts");
        final List<Account> account = accountRepository.findAll();
        if (ObjectUtils.isEmpty(account)) {
            logger.error("account listing not found");
            throw new ServiceException("account listing not found");
        }
        return account;
    }

    @Override
    public List<Transaction> findAccountTrans(final Long accountNumber) {
        if (ObjectUtils.isEmpty(accountNumber)) {
            throw new ServiceException("invalid accountNumber");
        }
        logger.info("AccountServiceImpl.find Account by AccountNumber" + accountNumber);
        final Optional<Account> accountDetails = accountRepository.findById(accountNumber);
        if (!(accountDetails.isPresent() || (ObjectUtils.isEmpty(accountDetails.get()
                                                                               .getTransactions())))) {
            throw new ServiceException("Transaction Listings not Found");
        }
        return accountDetails.get()
                             .getTransactions();
    }
}
