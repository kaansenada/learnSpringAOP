package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//eğer sadece pointcut var ise @Aspect anotasyonu opsiyonaldir
//sadece @Before @After gibi advice lar için gereklidir.
@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.add*(..))")
    public void forDaoAddMethods() {}

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void forDaoMethods() {}

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    public void forDaoGetMethods() {}

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    public void forDaoSetMethods() {}

    @Pointcut("forDaoSetMethods() || forDaoGetMethods()")
    public void forDaoGetterSetterMethods(){}
}
