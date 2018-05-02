package com.mex.global.population.model.dashboard;

import java.util.List;

public class DashBoardPopulationPie {
	
	private String title;
	private List<DataPie> data;

	
	public DashBoardPopulationPie(String title,List<DataPie> data) {
		this.title = title;
		this.data = data;
	}
	
	public String getTitle() {
		return title;
	}
	public List<DataPie> getData() {
		return data;
	}
}
