package com.example.aop.log;

import org.springframework.stereotype.Component;

/**
 * @author lidongmeng
 * Created on 2022-08-24
 */
@Component
public class MathCalculator {
	public int div(int i, int j) {
		return i / j;
	}


	@Override
	public String toString() {
		return "MathCalculator";
	}
}