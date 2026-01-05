package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {
    // burada tüm loglamalar için advicelar eklenir

    //pointcut'lar sık kullanılacak advice içeriklerini tutmak için kullanılır
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.add*(..))")
    private void forDaoAddMethods() {
    }

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDaoMethods() {
    }

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    private void forDaoGetMethods() {
    }

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    private void forDaoSetMethods() {
    }

    @Before("forDaoAddMethods()")
    public void beforeAddAccountAdvice() {
        System.out.println("=======> Excecuting @Before advice on update methods");
    }

    @Before("!forDaoAddMethods() && (forDaoGetMethods() ||forDaoSetMethods()) ")
    public void performApiAnalytics(){
        System.out.println("========> Performing API analytics");
    }
}
