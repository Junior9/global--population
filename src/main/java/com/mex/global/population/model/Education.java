package com.mex.global.population.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "education")
public class Education {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToMany(cascade = {CascadeType.REMOVE})
	private List<Data> data;
	
	
	public Education(List<Data> data){
		this.data = data;
	}
	
	public int getId() {
		return id;
	}
	public List<Data> getDatas() {
		return data;
	}
}
