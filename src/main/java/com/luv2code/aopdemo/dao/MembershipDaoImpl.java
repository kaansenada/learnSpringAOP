package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao {
    @Override
    public void addDummyMember() {
        System.out.println(getClass() + ": Adding membership to database....");
    }
}
