package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MembershipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao){
		return runner -> {
			demoBeforeAdvice(accountDao, membershipDao);


		};
	}

	private void demoBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao) {
		// call business method
		Account accountTest = new Account();

		accountDao.addAccount(accountTest,true);
		membershipDao.addDummyMember();
	}

}




