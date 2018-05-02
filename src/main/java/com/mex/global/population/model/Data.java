package com.mex.global.population.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data")
public class Data {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String year;
	private Integer value;
	
	Data(){}
	
	public Data(String year,Integer value){
		this.year = year;
		this.value = value;
	}
	
	public int getId() {
		return id;
	}
	public String getYear() {
		return year;
	}
	public Integer getValue() {
		return value;
	}
}