package com.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Source {

	public static void main(String[] args) {
		AbstractApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		Student s=ac.getBean(Student.class);
		Trainer t=ac.getBean(Trainer.class);
		s.studying();
		System.out.println("=======================");
	System.out.println(t.study());
		
	}

}
