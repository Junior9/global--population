package com.mex.global.population.upload.file.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mex.global.population.model.Country;
import com.mex.global.population.model.Data;
import com.mex.global.population.model.Population;

public class UploadaFileCSV {
	
	private static final Integer START_YEAR = 1960;
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int FIRST_POSITION_OF_YEARS = 5;
	private static final int TOTAL_YEARS = 62;
	
	
	public static Country mock(String name,String code, int value){
		Population population;
		List<Data> data = new ArrayList<Data>();
		for(int x= 2000; x <2017; x++) {
			value += 10000;
			data.add(new Data(String.valueOf(x)  , value ));
		}
		population = new Population(data);
		return new Country(name, code, population);
	}
	
	
	public static List<Country> mockList(){
		
		List<Country> list = new ArrayList<Country>();
		
		list.add( mock("Brazil", "Br", 1000000000));
		list.add( mock("Mexico", "Mx", 5000000));
		list.add( mock("Columbia", "Cl", 30000000));
		list.add( mock("Estados Unidos", "EUA", 10000000));
		list.add( mock("Canada", "Ca", 10000000));
		list.add( mock("Espain", "Sa", 3000000));
		list.add( mock("China", "Chi", 400000));
		return list;
	}
	
	public List<Country> uploadFileTotalCountry () {
		
		String csvFile = "C:\\Users\\morae\\Documents\\workspace-sts-3.9.2.RELEASE\\read-csv\\src\\main\\resources\\filesCSV\\API_SP.POP.TOTAL.csv";
	    String line = "";
	    String cvsSplitBy = ",";
	    List<Country> countries  = new ArrayList<Country>();
	    List<Data> data ;
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	    	String countryName = "";	
	    	String countryCode = "";
	    	
	    	int count = 0;
	    	
	        while ((line = br.readLine()) != null) {
	            
	            try {
	            	String[] country = line.split(cvsSplitBy);	
	            	countryName = country[ZERO];
	            	countryCode = country[ONE];
	            	data = new ArrayList<Data>();
	            	for(int year = FIRST_POSITION_OF_YEARS;year < TOTAL_YEARS;year++) { 
	            		
	            		
	            		if(countryCode.equals("World")) {
	            			System.out.println();
	            		}
	            		data.add(new Data(String.valueOf(START_YEAR + (year - 5) ), Integer.valueOf(  country [year].substring(1,country [year].length()-1 ) )));
	            	
	            	}
	            	countries.add(new Country(countryName,countryCode, new Population(data) ));
	            }catch(NumberFormatException erro) {
	            	count++;
	            	System.out.println("Pais" + countryName);
	            	erro.printStackTrace();
	            }
	            
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return countries;
	}


	public static Country mockCountry() {
		return mock("Brazil", "Br", 1000000000);
	}
}
