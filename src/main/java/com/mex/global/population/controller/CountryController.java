package com.mex.global.population.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mex.global.population.model.Country;
import com.mex.global.population.model.dashboard.DashBoardPopulationPie;
import com.mex.global.population.model.dashboard.DashboardPopulation;
import com.mex.global.population.service.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping("/country/all")
	public DashboardPopulation getAll() {
		return countryService.getAll();
	}
	
	@GetMapping("/country/all/pie")
	public DashBoardPopulationPie getAllPie() {
		return countryService.getAllPie();
	}
	
	@GetMapping("/country/{id}")
	public DashboardPopulation get(@PathVariable int id) {
		return countryService.get(id);
	}
	
	@GetMapping("country/basic/all")
	public Iterable<Country> getBasicAll(){
		return countryService.getBasicAll();
	}
}