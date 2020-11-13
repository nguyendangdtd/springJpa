/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyen.main;

import com.nguyen.entities.Account;
import com.nguyen.service.AccountService;
import com.nguyen.service.AccountServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author XV
 */
public class BankTransfer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml","jpa-config.xml");
        AccountService accountService = context.getBean("accountServiceImpl", AccountServiceImpl.class);
        
        List<Account> accs = new ArrayList();
        // Init data
        Account account1 = new Account();
        account1.setId(123);
        account1.setOwnerName("Cao Nguyen");
        account1.setBabance(50);
        
        Account account2 = new Account();
        account2.setId(234);
        account2.setOwnerName("Nhat Cong");
        account2.setBabance(50);
        
        accs.add(account1);
        accs.add(account2);
        
        accountService.initAccountData(accs);
        
        System.out.println("Thong tin truoc khi chuyen khoan");
        System.out.println(accountService.getAccount(123));
        System.out.println(accountService.getAccount(234));

        System.out.println("Thuc hien chuyen 10 Dong tu Account 0 sang Account 1");
        accountService.transfer(123, 234, 10);

        System.out.println("Thong tin sau khi chuyen khoan");
        System.out.println(accountService.getAccount(123));
        System.out.println(accountService.getAccount(234));
    }

}
