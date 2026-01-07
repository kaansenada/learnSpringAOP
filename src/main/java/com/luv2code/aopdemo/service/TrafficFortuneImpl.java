package com.luv2code.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneImpl implements TrafficFortuneService{
    @Override
    public String getFortune() {
        return getFortune(false);
    }

    @Override
    public String getFortune(boolean flag) {
        if(flag){
            throw new RuntimeException("Major Accident!!!");
        }
        try{
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Expect Heavy Traffic";
    }
}
