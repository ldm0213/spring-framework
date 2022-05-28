package com.example.ioc.pojo;

import org.springframework.stereotype.Component;

/**
 * @author lidongmeng
 * Created on 2022-02-21
 */
@Component
public class DowJonesNewsListener implements Listener {

	@Override
	public String[] getAvailableNewsIds() {
		System.out.println("getAvailableNewsIds");
		return new String[0];
	}

}
