/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyen.dao;

import com.nguyen.entities.Account;
import com.nguyen.entities.Bank;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author XV
 */
public interface BankRepository extends CrudRepository<Bank, Long> {

	@Query(value="SELECT * FROM bank b INNER JOIN account acc ON b.id = acc.bank_fk where acc.address=?1", nativeQuery=true)
    Bank findBankWithAccountAddressIs(String address);


	@Query("SELECT bnk FROM Bank bnk INNER JOIN bnk.accounts acc GROUP BY bnk " +
		"HAVING COUNT (bnk) > 1 ")
	Bank findBankWithMoreThan1Account();
}
