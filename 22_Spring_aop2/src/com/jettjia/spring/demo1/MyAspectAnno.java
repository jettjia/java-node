package com.jettjia.spring.demo1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;

/**
 * 注解方式的切面类
 */
@Aspect
public class MyAspectAnno {

	/**
	 * 前置通知
	 */
	@Before(value = "MyAspectAnno.pointcut1()")
	public void before() {
		System.out.println("前置增强");
	}

	/**
	 * 后置通知
	 * 
	 * @param result
	 */
	@AfterReturning(value = "MyAspectAnno.pointcut2()", returning = "result")
	public void AfterReturning(Object result) {
		System.out.println("后置增强" + result);
	}
	
	/**
	 * 环绕通知
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around(value = "MyAspectAnno.pointcut3()")
	public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("环绕增强前");
		Object proceed = joinPoint.proceed();
		System.out.println("环绕增强后");
		return proceed;
	}
	
	/**
	 * 异常通知
	 */
	@AfterThrowing(value = "MyAspectAnno.pointcut4()", throwing="ex")
	public void aterThrowing(Throwable ex) {
		System.out.println("异常增强" + ex.getMessage());
	}
	
	/**
	 * 最后通知
	 */
	@After(value = "MyAspectAnno.pointcut4()")
	public void after() {
		System.out.println("最后增强");
	}
	
	// 切入点注解
	@Pointcut(value = "execution(* com.jettjia.spring.demo1.OrderDao.save(..))")
	private void pointcut1(){}
	@Pointcut(value = "execution(* com.jettjia.spring.demo1.OrderDao.delete(..))")
	private void pointcut2(){}
	@Pointcut(value = "execution(* com.jettjia.spring.demo1.OrderDao.update(..))")
	private void pointcut3(){}
	@Pointcut(value = "execution(* com.jettjia.spring.demo1.OrderDao.find(..))")
	private void pointcut4(){}
}
