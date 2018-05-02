package com.mex.global.population.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mex.global.population.model.Country;
import com.mex.global.population.model.Data;
import com.mex.global.population.model.Population;
import com.mex.global.population.repository.CountryRepository;
import com.mex.global.population.repository.DataRepository;
import com.mex.global.population.repository.PopulationRepository;
import com.mex.global.population.upload.file.csv.UploadaFileCSV;

@Service
public class FileUploadService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private PopulationRepository populationRepository;
	
	@Autowired
	
	private DataRepository dataRepository;
	
	private UploadaFileCSV uploadaFileCSV;
	
	public void initData() {
		
		uploadaFileCSV = new UploadaFileCSV();
		List<Country> list = uploadaFileCSV.uploadFileTotalCountry();
		saveFileUpload(list);
	}
	
	private void saveFileUpload(List<Country> uploadFileTotalPopulation) {
		Population populationAux = null;
		for (Country country : uploadFileTotalPopulation) {
			
			List<Data> data = country.getPopulation().getData();
			data  = (List<Data>) dataRepository.save(data);
			country.getPopulation().setData(data);
			
			populationAux = populationRepository.save(country.getPopulation());
			country.setPopulation(populationAux);
			countryRepository.save(country);
		}
	}
	
	public List<Country> mockPopulation() {
		return UploadaFileCSV.mockList();
	}

	public Country mockCountry() {
		return UploadaFileCSV.mockCountry();
	}
}
