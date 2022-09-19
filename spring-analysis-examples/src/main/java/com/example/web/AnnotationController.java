package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lidongmeng
 * Created on 2022-09-19
 */
@Controller
public class AnnotationController {

	@RequestMapping(value = "/test")
	public String goTest(HttpServletRequest request) {
		// 输出请求 URL 路径
		System.out.println(request.getRequestURL());
		// 返回逻辑名
		return "index";
	}
}