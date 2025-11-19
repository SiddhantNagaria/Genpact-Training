package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component // register this class as a spring bean , so that spring can manage it.
@Order(1) // multiple aspects exists, define priority,1 -> highest priority
public class CalculatorAspect {

	// code - how we can do logging along side business logic

	// define a point cut - where your advices will apply - target methods
	// match all public methods in CalculatorService class
	// methods - can have ant number of arguments
	@Pointcut("execution(public * com.aop.CalculatorService.*(..))")
	public void calculatorMethods() {
	}

	// advices -> for all matching methods - add(), divide()

	@Before("calculatorMethods()")
	public void before(JoinPoint jp) {
		System.out.println("[AOP-BEFORE] Calling: " + jp.getSignature().toShortString());
	}

	@Around("calculatorMethods()") // runs both before and after target methods
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		// lets you control when the actual method executes
		// pjp.proceed()
		long start = System.currentTimeMillis();

		try {
			System.out.println("[AOP-AROUND] Starting : " + pjp.getSignature().toShortString());
			Object result = pjp.proceed();
			long time = System.currentTimeMillis() - start;
			System.out.println("[AOP-AROUND Completed : " + time + "ms" + pjp.getSignature().toShortString());
			return result;
		} catch (Throwable e) {
			long time = System.currentTimeMillis() - start;
			System.out.println("[AOP-AROUND] Throw after : " + time + "ms" + e.getClass().getSimpleName());
			throw e;
		}
	}

	@AfterReturning(pointcut = "calculatorMethods()", returning = "ret")
	public void afterReturning(JoinPoint jp, Object ret) {
		System.out.println("[AOP-AFTER-RETURNING] " + jp.getSignature().toShortString() + "returned : " + ret);
	}

	@AfterThrowing(pointcut = "calculatorMethods()", throwing = "ex")
	public void afterThrowing(JoinPoint jp, Throwable ex) {
		System.out.println("[AOP-AFTER-THROWING] " + jp.getSignature().toShortString() + "threw : "
				+ ex.getClass().getSimpleName() + " " + ex.getMessage());
	}

	
	@After("calculatorMethods()")
	public void afterFinal(JoinPoint jp) {
		System.out.println("[AOP-AFTER] : " + jp.getSignature().toShortString());
	}
}
