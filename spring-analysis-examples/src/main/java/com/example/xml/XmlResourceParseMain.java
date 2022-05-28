package com.example.xml;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author lidongmeng
 * Created on 2022-05-24
 */
public class XmlResourceParseMain {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("classpath:beans.xml");
		System.out.println(resource.getDescription());
	}
}
