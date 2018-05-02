package com.mex.global.population.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mex.global.population.model.Country;
import com.mex.global.population.model.Data;
import com.mex.global.population.model.dashboard.DashBoardPopulationPie;
import com.mex.global.population.model.dashboard.DashboardPopulation;
import com.mex.global.population.model.dashboard.DataPie;
import com.mex.global.population.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	public DashboardPopulation getAll() {
		Iterable<Country> countries1 = countryRepository.findAll();
		Map<String,Integer> mapGlobalPopulation = createMapAllPopulation((List<Country>) countries1);
		return createDashBoardPopulation(mapGlobalPopulation,"World Population","population");
	}
	
	public DashboardPopulation get(int id) {
		Country country = countryRepository.findById(id);
		Map<String,Integer> mapGlobalPopulation = createMapCountryPopulation(country);
		return createDashBoardPopulation(mapGlobalPopulation,country.getName(),country.getCode());		
	}
	
	public DashBoardPopulationPie getAllPie() {
		List<Country> countries = (List<Country>) countryRepository.findAll();
		
		List <DataPie> data = new ArrayList<DataPie>();
		Integer dataY  = 0;
		for (Country country : countries) {
   			dataY =  country.getPopulation().getData().get(country.getPopulation().getData().size() -1 ).getValue();
			data.add(new DataPie(country.getName(),dataY));
		}
		return new DashBoardPopulationPie("Global Population", data);
	}

	private Map<String, Integer> createMapCountryPopulation(Country country) {
		return dataCountry(country, new LinkedHashMap<String,Integer>());
	}

	private DashboardPopulation createDashBoardPopulation(Map<String, Integer> mapGlobalPopulation, String title, String subTitle) {
		List<String> categories = new ArrayList<String>();
		List<Integer> series = new ArrayList<Integer>();
			
		for (String key : mapGlobalPopulation.keySet()) {
			categories.add(key);
			series.add(mapGlobalPopulation.get(key));
		}
		return new DashboardPopulation(title,subTitle,categories,series);
	}

	private Map<String, Integer> createMapAllPopulation(List<Country> countries) {
		Map<String,Integer> mapGlobalPopulation = new LinkedHashMap<String,Integer>();
		
		for (Country country : countries) {	
			mapGlobalPopulation = dataCountry(country,mapGlobalPopulation);
		}
		return mapGlobalPopulation;
	}

	private Map<String, Integer> dataCountry(Country country, Map<String, Integer> mapGlobalPopulation) {
		Integer numberPopulationByYear = 0;
 		
		for(Data data : country.getPopulation().getData() ) {
		
			if(!mapGlobalPopulation.containsKey(data.getYear())){
				mapGlobalPopulation.put(data.getYear(), data.getValue());
			}else {
				numberPopulationByYear = mapGlobalPopulation.get(data.getYear());
				numberPopulationByYear += data.getValue();
				mapGlobalPopulation.put(data.getYear(),numberPopulationByYear);
			}
		}
		return mapGlobalPopulation;
	}

	public Iterable<Country> getBasicAll() {
		return countryRepository.findAll();
	}
}