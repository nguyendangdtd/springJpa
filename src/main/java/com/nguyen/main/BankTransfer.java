/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyen.main;

import com.nguyen.dao.AccountRepository;
import com.nguyen.dao.BankRepository;
import com.nguyen.entities.Account;
import com.nguyen.entities.Bank;
import com.nguyen.service.AccountService;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public static void main(String[] args) throws ParseException {
		ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml", "jpa-config.xml");
		BankRepository bankRepository = context.getBean(BankRepository.class);
		AccountRepository accountRepository = context.getBean(AccountRepository.class);

		insertListOfAccount(accountRepository);
		insertListOfBanks(bankRepository);
		setBankForAccount(accountRepository, bankRepository);

		final Bank accountWithMoreThan1Banking = bankRepository.findBankWithMoreThan1Account();
		System.out.println(accountWithMoreThan1Banking);
		System.out.println("List of accounts: " + accountWithMoreThan1Banking.getAccounts().size());

		final Bank bankHasAccountAdressIsSaiGon = bankRepository.findBankWithAccountAddressIs("Sai Gon");
		System.out.println(bankHasAccountAdressIsSaiGon);
	}

	static void setBankForAccount(AccountRepository accountRepository,
		BankRepository bankRepository) {
		final Optional<Account> acc1Opt = accountRepository.findById(123l);
		final Optional<Account> acc2Opt = accountRepository.findById(234l);
		final Optional<Account> acc3Opt = accountRepository.findById(345l);
		final Optional<Bank> vcbOpt = bankRepository.findById(111l);
		final Optional<Bank> tpbOpt = bankRepository.findById(112l);
		Account acc1 = acc1Opt.get();
		acc1.setBank(vcbOpt.get());
		Account acc2 = acc2Opt.get();
		acc2.setBank(vcbOpt.get());
		Account acc3 = acc3Opt.get();
		acc3.setBank(tpbOpt.get());
		accountRepository.save(acc1);
		accountRepository.save(acc2);
		accountRepository.save(acc3);
	}

	static void transferMoney(long fromAccId, long toAccId, double amount, AccountService accountService) {
		System.out.println("Thong tin truoc khi chuyen khoan");
		System.out.println(accountService.getAccount(fromAccId));
		System.out.println(accountService.getAccount(toAccId));

		System.out.println("Thuc hien chuyen tien");
		accountService.transfer(fromAccId, toAccId, amount);

		System.out.println("Thong tin sau khi chuyen khoan");
		System.out.println(accountService.getAccount(fromAccId));
		System.out.println(accountService.getAccount(toAccId));
	}

	static void insertListOfBanks(BankRepository bankRepository) {
		Bank vcb = new Bank();
		vcb.setId(111);
		vcb.setBankName("Ngan Hang Ngoai Thuong");
		vcb.setBankAddress("111 Le Loi, Da Nang");
		bankRepository.save(vcb);

		Bank tpb = new Bank();
		tpb.setId(112);
		tpb.setBankName("Ngan Hang Tien Phong");
		tpb.setBankAddress("112 Nguyen Van Linh, Da Nang");
		bankRepository.save(tpb);

	}

	static void insertListOfAccount(AccountRepository accountRepository) throws ParseException {
		List<Account> accs = new ArrayList();
		// Init data
		Account account1 = new Account();
		account1.setId(123);
		account1.setOwnerName("Cao Nguyen");
		account1.setBabance(50);
		account1.setAddress("Da Nang");
		account1.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-15"));

		Account account2 = new Account();
		account2.setId(234);
		account2.setOwnerName("Nhat Cong");
		account2.setBabance(50);
		account2.setAddress("Da Nang");
		account2.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-14"));

		Account account3 = new Account();
		account3.setId(345);
		account3.setOwnerName("Nguyen Minh");
		account3.setBabance(80);
		account3.setAddress("Sai Gon");
		account3.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-10-15"));

		accs.add(account1);
		accs.add(account2);
		accs.add(account3);

		accountRepository.saveAll(accs);
	}

}
