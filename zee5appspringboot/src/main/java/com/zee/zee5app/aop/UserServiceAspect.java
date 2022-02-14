package com.zee.zee5app.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect //container where all aop code is stored
public class UserServiceAspect {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	
	
	@Before(value="execution(* com.zee.zee5app.service.impl.*.*(..))")//first *->all classes,next methods,then any arguements
	//pattern is the point cut and the method is advice,link of point cut and advice or method which caused the execution
	public void beforeAllServiceMethods()
	{
		System.out.println("hello");
	}
	
	
	@After(value="execution(* com.zee.zee5app.service.impl.*.*(..))")//
	public void afterAllServiceMethods()
	{
		System.out.println("after");
}
	
	
	@Pointcut("within(@org.springframework.stereotype.Repository *)"+
			" || within(@org.springframework.stereotype.Service *)"+
			" || within(@org.springframework.web.bind.annotation.RestController *)")
	public void springPointCutExp()
	
	{
		
		
	}
	@Pointcut("within(com.zee.zee5app.controller..*)"+
			" || within(com.zee.zee5app.service.impl..*)")//2 dots includes all classes
	public void springPointCutExp1()
	
	{
		
		
	}
	@AfterThrowing(pointcut="springPointCutExp() && springPointCutExp1()",throwing="e")
	public void logAfterThrowingException(JoinPoint joinpoint,Throwable e)
	{
		logger.error("exception {}{}{} with cause{}",joinpoint.getSignature().getDeclaringTypeName(),
				joinpoint.getSignature().getName(),e.getCause()!=null?e.getCause():"NULL");
	}
//@Around(value="execution(* com.zee.zee5app.service.impl.*.*(..))")
//public void aroundExecution(ProceedingJoinPoint joinpoint) throws Throwable
//{
//	System.out.println("before method execution");
//	try {
//		joinpoint.proceed();
//	} catch (Throwable e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	System.out.println("after method execution");
//}

}
