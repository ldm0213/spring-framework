package com.example.cycleDepen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lidongmeng
 * Created on 2023-05-09
 */
@Component
public class CycleA {
	@Autowired
	private CycleB cycleB;
}
