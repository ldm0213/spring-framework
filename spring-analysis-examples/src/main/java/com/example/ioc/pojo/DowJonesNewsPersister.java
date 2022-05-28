package com.example.ioc.pojo;

import org.springframework.stereotype.Component;

/**
 * @author lidongmeng
 * Created on 2022-02-21
 */
@Component
public class DowJonesNewsPersister implements Persister {

	@Override
	public void persistNews(String[] newsIds) {
		System.out.println("DowJonesNews");
	}

}
