package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class MyDemoLoginAspect {

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{
        String methodName = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=======> Executing @Around on method: " + methodName);

        long beginTime = System.nanoTime();
        Object result;
        try {
            result = proceedingJoinPoint.proceed();
        }catch (Exception e){
            System.out.println(e.getMessage());
            result = "Major Accident Take Caution";
        }
        long endTime = System.nanoTime();

        System.out.println("Duration:  " + (endTime-beginTime) + " nanosecs");

        return result;
    }

    @After("execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))")
    public void afterAdvice(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n=======> Executing @After on method: " + methodName);
    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))",
            throwing = "exception"
    )
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception){
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n=======> Executing @AfterThrowing on method: " + methodName);

        System.out.println("\n=======> Exception is  " + exception);
    }

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("\n=======> Executing @AfterReturning on method: " + methodName);

        System.out.println("\n=======> Result is: " + result);

        //burada gelen sonucu döndükten sonra değiştiebiliriz mesela id gibi önemli alanlar null olabilir veya dto olarak değiştirilebilir
        convertNamesToUperCase(result);
        System.out.println("\n=====> Changed Result is: " + result);
    }

    private void convertNamesToUperCase(List<Account> result) {
        result.forEach(account -> account.setName(account.getName().toUpperCase()));
    }

    @Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoAddMethods()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("=======> Excecuting @Before advice on update methods");

        Signature signature = joinPoint.getSignature();
        //bu access modifiersız şekilde path verir
        System.out.println("İmza: " + signature);
        //bu access modifier (public, private...) eklenmiş halini verir
        System.out.println("İmza Long String: " + signature.toLongString());
        //bu sadece class ve method ismini verir
        System.out.println("İmza Short String: " + signature.toShortString());

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            System.out.println(arg);
            if(arg instanceof Account){
                Account accountArg = (Account) arg;
                System.out.println("Name: " + accountArg.getName());
                System.out.println("Level: " + accountArg.getLevel());
            }
        }
    }
}
