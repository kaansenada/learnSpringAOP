package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{

    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();
        Account accountOne = new Account("Kaan","Platinum");
        Account accountTwo = new Account("Halil","Gold");
        Account accountThree = new Account("Sude","Silver");

        accounts.add(accountOne);
        accounts.add(accountTwo);
        accounts.add(accountThree);

        return accounts;
    }

    @Override
    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass() + ": ADDING ACCOUNT...");
    }

    public String getName() {
        System.out.println(getClass() + ": called getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": called setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": called getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": called setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
