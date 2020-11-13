/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyen.service;

import com.nguyen.entities.Account;
import java.util.List;

/**
 *
 * @author XV
 */
public interface AccountService {
    void transfer(long fromAccountId, long toAccountId, double amount);
    Account getAccount (long accountId);
    void initAccountData(List<Account> accounts);
}
