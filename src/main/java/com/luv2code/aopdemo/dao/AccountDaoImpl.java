package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Override
    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass() + ": ADDING ACCOUNT...");
    }
}
