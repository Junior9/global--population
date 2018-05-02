package com.mex.global.population.model.dashboard;

import java.util.List;

public class DashboardPopulation {
	
	private String title;
	private String subTitle;
	private List<String> categories;
	private List<Integer> series;

	public DashboardPopulation(String title, String subTitle, List<String> categories, List<Integer> series) {
		this.title = title;
		this.subTitle = subTitle;
		this.categories = categories;
		this.series = series;
	}
	public String getTitle() {
		return title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public List<String> getCategories() {
		return categories;
	}
	public List<Integer> getSeries() {
		return series;
	}
}
