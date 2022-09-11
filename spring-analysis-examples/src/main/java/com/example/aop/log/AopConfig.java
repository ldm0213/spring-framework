package com.example.aop.log;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lidongmeng
 * Created on 2022-08-24
 */
@ComponentScan("com.example.aop.log")
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

}
