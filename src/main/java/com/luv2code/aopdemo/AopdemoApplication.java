package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MembershipDao;
import com.luv2code.aopdemo.service.TrafficFortuneService;
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
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao, TrafficFortuneService trafficFortuneService){
		return runner -> {
			demoBeforeAdvice(accountDao, membershipDao);
			demoAfterReturningAdvice(accountDao);
			demoAfterThrowingAdvice(accountDao);
			demoAfterAdvice(accountDao);
			demoAroundAdvice(trafficFortuneService);
			demoAroundAdviceHandleException(trafficFortuneService);
		};
	}

	private void demoAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("DemoAroundAdviceHandleException");
		System.out.println("-------------------");
		System.out.println("Calling getFortune()");
		boolean flag = true;
		String data = trafficFortuneService.getFortune(flag);
		System.out.println("Fortune is: "+data);
	}

	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("DemoAroundAdvice");
		System.out.println("-------------------");
		System.out.println("Calling getFortune()");
		String data = trafficFortuneService.getFortune();
		System.out.println("Fortune is: "+data);
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
	}

	private void demoAfterReturningAdvice(AccountDao accountDao) {
		System.out.println("DemoAfterAdvice");
		System.out.println("-------------------");

		List<Account> accounts = accountDao.findAccounts();

		System.out.println("Accounts: " + accounts);
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




