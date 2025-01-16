package com.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.savetravels.models.TravelModel;

public interface TravelRepository extends CrudRepository<TravelModel,Long> {
	List<TravelModel> findAll();

}
