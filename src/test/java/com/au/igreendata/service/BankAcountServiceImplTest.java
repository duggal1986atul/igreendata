package com.au.igreendata.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.au.igreendata.model.Account;
import com.au.igreendata.model.Transaction;
import com.au.igreendata.repository.AccountRepository;

@RunWith(MockitoJUnitRunner.class)
public class BankAcountServiceImplTest {

    @InjectMocks
    private BankAccountServiceImpl bookingService;
    @Mock
    private AccountRepository      accountRepository;
    List<Transaction>              listing;
    final Account                  account = mock(Account.class);

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllAccountsWithData() throws Exception {
        final List<Account> accounts = mock(List.class);
        when(accountRepository.findAll()).thenReturn(accounts);
        final List<Account> response = bookingService.getAllAccounts();
        assertNotNull(response);
    }

    @Test
    public void getAccountsWithTransactionData() throws Exception {
        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));
        final List<Transaction> response = bookingService.findAccountTrans(1l);
        assertNotNull(response);
    }
}
