/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyen.main;

import com.nguyen.dao.BankRepository;
import com.nguyen.entities.Account;
import com.nguyen.entities.Bank;
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
        BankRepository bankRepository = context.getBean(BankRepository.class);
        printUser(accountService, 123l);
    }

    static void initdata(AccountService accountService, BankRepository bankRepository) {
        List<Account> accs = new ArrayList();
        // Init data
        Account account1 = new Account();
        account1.setId(123);
        account1.setOwnerName("Cao Nguyen");
        account1.setBabance(50);
        // account1.setBanks(banks);


        Account account2 = new Account();
        account2.setId(234);
        account2.setOwnerName("Nhat Cong");
        account2.setBabance(50);

        /*List<Bank> banks2 = new ArrayList();
        banks2.add(vcb);
        account2.setBanks(banks2);*/

        accs.add(account1);
        accs.add(account2);

        accountService.initAccountData(accs);

        Bank vcbAcc1 = new Bank();
        vcbAcc1.setBankName("VCB");
        vcbAcc1.setBankAddress("Chi Nhanh Da Nang");
        vcbAcc1.setAccount(account1);
        bankRepository.save(vcbAcc1);

        Bank tpbAcc1 = new Bank();
        tpbAcc1.setBankName("TPB");
        tpbAcc1.setBankAddress("Chi Nhanh Da Nang");
        tpbAcc1.setAccount(account1);
        bankRepository.save(tpbAcc1);

        Bank tpbAcc2 = new Bank();
        tpbAcc2.setBankName("TPB");
        tpbAcc2.setBankAddress("Chi Nhanh Da Nang");
        tpbAcc2.setAccount(account2);
        bankRepository.save(tpbAcc2);

        System.out.println("Thong tin truoc khi chuyen khoan");
        System.out.println(accountService.getAccount(123));
        System.out.println(accountService.getAccount(234));

        System.out.println("Thuc hien chuyen 10 Dong tu Account 0 sang Account 1");
        accountService.transfer(123, 234, 10);

        System.out.println("Thong tin sau khi chuyen khoan");
        System.out.println(accountService.getAccount(123));
        System.out.println(accountService.getAccount(234));
    }

    static void printUser(AccountService accountService, Long userId) {
        Account account = accountService.getAccount(userId);
        System.out.println(account);
        System.out.println("===============get bank size===================");
        System.out.println(account.getBanks().size());
    }

}
