package com.mex.global.population.model.dashboard;

public class DataPie {
	
	private String name;
	private Integer y;
	
	public DataPie(String name, Integer y) {
		this.name = name;
		this.y = y;
	}

	public String getName() {
		return name;
	}
	public Integer getY() {
		return y;
	}
}
