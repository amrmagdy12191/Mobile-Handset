package com.mobile.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Configuration
@Aspect
public class LoggingAspect {
	
	@Before("execution(* com.mobile..*(..))")
	public void log(JoinPoint joinPoint) {
		System.out.println("==> logMethods");
		MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
		System.out.println(methodSignature);
		
		
		Object[]args = joinPoint.getArgs();
		System.out.println("[");
		for (Object object : args) {
			System.out.print(object.toString() + ", ");		
		}
		System.out.println("]");
	}

}
