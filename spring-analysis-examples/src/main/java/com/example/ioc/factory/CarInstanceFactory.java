package com.example.ioc.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lidongmeng
 * Created on 2022-06-16
 */
public class CarInstanceFactory {
	private Map<Integer, Car> map = new HashMap<>();

	public void setMap(Map<Integer, Car> map) {
		this.map = map;
	}

	public CarInstanceFactory(){
	}

	public Car getCar(int id){
		return map.get(id);
	}
}