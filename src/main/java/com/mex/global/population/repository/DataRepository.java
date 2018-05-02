package com.mex.global.population.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mex.global.population.model.Data;

@Repository
public interface DataRepository  extends CrudRepository<Data, String>{}
