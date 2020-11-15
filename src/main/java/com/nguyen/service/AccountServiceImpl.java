/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyen.service;

import com.nguyen.entities.Account;
import com.nguyen.dao.AccountRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author XV
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account getAccount(long accountId) {
        Optional<Account> accountOpt = accountRepository.findById(accountId);
        return accountOpt.isPresent() ? accountOpt.get() : null;
    }

    @Override
    public void transfer(long fromAccountId, long toAccountId, double amount) {

        Account accFrom = getAccount(fromAccountId);
        accFrom.setBabance(accFrom.getBabance() - amount);
        Account accTo = getAccount(toAccountId);
        accTo.setBabance(accTo.getBabance() + amount);

        accountRepository.save(accFrom);
        accountRepository.save(accTo);
    }

}
