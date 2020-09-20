package com.au.igreendata.service;

import java.util.List;

import com.au.igreendata.exception.ServiceException;
import com.au.igreendata.model.Account;
import com.au.igreendata.model.Transaction;

public interface BankAccountService {

    public List<Account> getAllAccounts() throws ServiceException;

    public List<Transaction> findAccountTrans(Long accountNumber) throws ServiceException;
}
