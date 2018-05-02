package com.mex.global.population.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "country",uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String code;
	@OneToOne()
	private Population population;
	
	public Country() {}
	
	public Country(String name,String code,Population population) {
		this.name = name;
		this.code = code;
		this.population = population;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public Population getPopulation() {
		return population;
	}

	public void setPopulation(Population population) {
		this.population = population;
	}
	

	public boolean equals(Country country) {
		if(this.name.equals(country.getName())) {
			return true;
		}
		return false;
	}
}