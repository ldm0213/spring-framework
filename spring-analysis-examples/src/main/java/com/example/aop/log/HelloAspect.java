package com.example.aop.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lidongmeng
 * Created on 2022-07-19
 */
@Aspect
@Component
public class HelloAspect {
	@Pointcut("execution(public int com.example.aop.log.MathCalculator.div(int, int))")
	public void pointcut() {
	}

	@AfterThrowing(value = "pointcut()", throwing = "exception")
	public void logException(JoinPoint joinPoint, Exception exception) {
		System.out.println(" " + joinPoint.getSignature().getName() +
				" 的 【HelloAspect-logException】 方法 除法出现异常，异常信息:{" + exception + "}");
	}
}