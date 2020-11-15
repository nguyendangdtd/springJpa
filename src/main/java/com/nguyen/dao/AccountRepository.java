/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyen.dao;

import com.nguyen.entities.Account;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author XV
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
	Account findByAddressEquals(String address);
}
