package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoginAspect {
    // burada tüm loglamalar için advicelar eklenir

    //pointcut'lar sık kullanılacak advice içeriklerini tutmak için kullanılır
    @Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoAddMethods()")
    public void beforeAddAccountAdvice() {
        System.out.println("=======> Excecuting @Before advice on update methods");
    }





}
