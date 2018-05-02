package com.mex.global.population.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mex.global.population.model.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {

}
