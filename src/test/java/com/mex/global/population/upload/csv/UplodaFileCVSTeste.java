package com.mex.global.population.upload.csv;

import java.util.List;

import com.mex.global.population.model.Country;
import com.mex.global.population.model.Population;
import com.mex.global.population.upload.file.csv.UploadaFileCSV;

import junit.framework.TestCase;

public class UplodaFileCVSTeste extends TestCase {
	
	
	private static UploadaFileCSV uploadaFileCSV;
	private static List<Country> listOFCountry;
	
	
	//@Before 
	public static void init() {
		uploadaFileCSV = new UploadaFileCSV();
		listOFCountry = uploadaFileCSV.uploadFileTotalCountry();
	}
	
	public void uploadFileTotalCountryFindArubaTest() {
		Population population = new Population();
		Country country = new Country("Aruba","ABW",population);
		
		//assertEquals(Boolean.TRUE, listOFCountry.contains(country));
	}
	
	
	public void uploadFileTotalCountrySizeTest() {
		assertEquals(554, listOFCountry.size());
	}

	
	
	
	
}
