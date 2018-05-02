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
@Table(name = "population")
public class Population {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToMany(cascade = {CascadeType.REMOVE})
	private List<Data> data;
	
	public Population() {}
	
	public Population(List<Data> data){
		this.data = data;
	}
	
	public int getId() {
		return id;
	}
	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}
}
