package com.exam.core;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {

	 public void bm(JoinPoint jp) {
	        
	 
	        //실행될 타겟메서드가 속한 객체의 클래스명
	        String className = jp.getTarget().getClass().getSimpleName();
	       
	        String methodName = jp.getSignature().getName(); //실행될 타겟메서드명
	 
	        System.out.println("MyAdvice bm 실행."+className + "." + methodName);
	    }
	 
	 public void am(JoinPoint jp) {
	        
		 
	        //실행될 타겟메서드가 속한 객체의 클래스명
	        String className = jp.getTarget().getClass().getSimpleName();
	       
	        String methodName = jp.getSignature().getName(); //실행될 타겟메서드명
	 
	        System.out.println("MyAdvice am 실행."+className + "." + methodName);
	    }
	 
	 
	 public Object rm(ProceedingJoinPoint pjp) throws Throwable {
	        System.out.println("MyAdvice rm start.");
	        long time1 = System.currentTimeMillis();
	        
	        Object retVal = pjp.proceed();//타겟메서드 실행
	 
	        System.out.println("ProceedingJoinPoint executed. return value is ["+ retVal + "]");
	 
	        retVal = retVal + "(modified)";
	        System.out.println("return value modified to [" + retVal + "]");
	 
	        long time2 = System.currentTimeMillis();
	        System.out.println("MyAdvice rm end. Time("+ (time2 - time1) + ")");
	        return retVal;
	    }
	 
	 
}
