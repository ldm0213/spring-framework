package com.example.ioc.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author lidongmeng
 * Created on 2022-02-21
 */
@Component
public class NewsProvider {
	public static final String SEQ = "160";

	@Autowired
	private Listener newsListener;

	@Autowired
	private Persister newsPersister;

	// IOC通过构造方法注入
	public NewsProvider(Listener newsListener, Persister newsPersister) {
		this.newsListener = newsListener;
		this.newsPersister = newsPersister;
	}

	public NewsProvider() {
	}

	public void getAndPersistNews() {
		System.out.println("seq=" + SEQ);
		String[] newsIds = newsListener.getAvailableNewsIds();
		System.out.println(newsIds.length);
		newsPersister.persistNews(newsIds);
	}

	//通过setter注入
	public void setNewsListener(Listener newsListener) {
		this.newsListener = newsListener;
	}

	public void setNewsPersister(Persister newsPersister) {
		this.newsPersister = newsPersister;
	}
}
