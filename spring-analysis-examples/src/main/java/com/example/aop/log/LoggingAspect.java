package com.example.aop.log;


import java.util.Arrays;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author lidongmeng
 * Created on 2022-07-19
 */
@Aspect
@Component
public class LoggingAspect {
	@Pointcut("execution(public int com.example.aop.log.MathCalculator.div(int, int))")
	public void pointcut() {
	}

	@Before("pointcut()")
	public void logStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		System.out.println(" " + joinPoint.getSignature().getName() +
				" 的【logStart】方法，除法开始运行，参数列表是: {" + Arrays.asList(args) + "}");
	}

	@After("pointcut()")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println(" " + joinPoint.getSignature().getName() + " 的【logEnd】方法，除法结束");
	}

	@AfterReturning(value = "pointcut()", returning = "result")
	public void logReturn(Object result) {
		System.out.println("【logReturn】方法: 运行结果:{" + result + "}");
	}

	@AfterThrowing(value = "pointcut()", throwing = "exception")
	public void logException(JoinPoint joinPoint, Exception exception) {
		System.out.println(" " + joinPoint.getSignature().getName() +
				" 的 【logException】 方法 除法出现异常，异常信息:{" + exception + "}");
	}
}