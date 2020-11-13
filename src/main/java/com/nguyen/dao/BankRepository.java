/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyen.dao;

import com.nguyen.entities.Bank;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author XV
 */
public interface BankRepository extends CrudRepository<Bank, Long> {
    
}
