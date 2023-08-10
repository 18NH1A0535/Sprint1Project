package com.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Human {

	@Before("execution(public * study*())")
public void wakeUp() {
	System.out.println("Good Morning!!!!");
}
	@After("execution(public * study*())")
	public void greet() {
		System.out.println("Happy Learning, Bye !!!!");
	}
}
