package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAccounts();
    List<Account> findAccounts(boolean flag);

    void addAccount(Account account, boolean flag);

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);

}
