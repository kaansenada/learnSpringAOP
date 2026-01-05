package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {
    // burada tüm logmlamalar için advicelar eklenir

    @Before("execution(* com.luv2code.aopdemo.dao.*.add*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=======> Excecuting @Before advice on updateAccount()");
    }
}
