package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MembershipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao){
		return runner -> {
			demoBeforeAdvice(accountDao, membershipDao);
			demoAfterReturningAdvice(accountDao);
			demoAfterThrowingAdvice(accountDao);
			demoAfterAdvice(accountDao);
		};
	}

	private void demoAfterAdvice(AccountDao accountDao) {
		System.out.println("DemoAfterThrowingAdvice");
		System.out.println("-------------------");

		List<Account> accounts = null;
		try{
			boolean flag = false;
			accounts = accountDao.findAccounts(flag);
		}catch (Exception e){
			System.out.println("Exceptption: " + e);
		}

		System.out.println("Accounts: " + accounts);
		System.out.printf("\n");
	}

	private void demoAfterThrowingAdvice(AccountDao accountDao) {
		System.out.println("DemoAfterThrowingAdvice");
		System.out.println("-------------------");

		List<Account> accounts = null;
		try{
			boolean flag = true;
			accounts = accountDao.findAccounts(flag);
		}catch (Exception e){
			System.out.println("Exceptption: " + e);
		}

		System.out.println("Accounts: " + accounts);
		System.out.printf("\n");
	}

	private void demoAfterReturningAdvice(AccountDao accountDao) {
		System.out.println("DemoAfterAdvice");
		System.out.println("-------------------");

		List<Account> accounts = accountDao.findAccounts();

		System.out.println("Accounts: " + accounts);
		System.out.printf("\n");
	}

	private void demoBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {
		System.out.println("\n\nDemoBeforeAdvice");
		System.out.println("-------------------");
		// call business method
		Account accountTest = new Account();
		accountTest.setName("Deneme Account");
		accountTest.setLevel("Deneme Level");

		accountDao.addAccount(accountTest,true);
		accountDao.setName("KaanDao");
		accountDao.setServiceCode("0000311313");

		String name = accountDao.getName();
		String serviceCodeAtHand = accountDao.getServiceCode();

		membershipDao.addDummyMember();
	}

}




