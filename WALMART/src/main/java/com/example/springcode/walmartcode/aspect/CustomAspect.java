package com.example.springcode.walmartcode.aspect;

/* import java.util.logging.Logger;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspects {
	
	
	
	
	// setup the logger
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	// setup pointcut declaration
	@Pointcut("execution(* com.example.springcode.walmartcode.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.example.springcode.walmartcode.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		String method= theJoinPoint.getSignature().toShortString();
		myLogger.info("===>> in @ Before: calling method:" + method);
		
		//display the arguments to the method
		
		//get the Arguments
		Object[] args= theJoinPoint.getArgs();
		
		// loop thru and display args
		for(Object tempAr :args) {
			myLogger.info("===>> argument   :"+tempAr);
		}
	}
	// add @AfterReturing Annotation
	@AfterReturning(pointcut="forAppFlow()", returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		String method= theJoinPoint.getSignature().toShortString();
		myLogger.info("===>> in @AfterReturning: from method:" + method);
		
		// display data returned
		myLogger.info("===>> Final result   :"+theResult);

	}
	

}*/
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAspect {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	public void controller() {
	}

	@Pointcut("execution(* com.example.springcode.walmartcode.controller.*.*(..))")
	protected void allMethod() {
	}
	
	
	@Around("controller() && allMethod()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		try {
			String className = joinPoint.getSignature().getDeclaringTypeName();
			String methodName = joinPoint.getSignature().getName();
			Object result = joinPoint.proceed();
			long elapsedTime = System.currentTimeMillis() - start;
			log.debug("Method " + className + "." + methodName + " ()" + " execution time : "
					+ elapsedTime + " ms");
		
			return result;
		} catch (IllegalArgumentException e) {
			log.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
					+ joinPoint.getSignature().getName() + "()");
			throw e;
		}
	}
	
	

}

