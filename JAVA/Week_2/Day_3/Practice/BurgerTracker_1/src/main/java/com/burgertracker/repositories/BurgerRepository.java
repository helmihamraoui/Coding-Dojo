package com.burgertracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.burgertracker.models.BourgerModel;

public interface BurgerRepository extends CrudRepository<BourgerModel,Long> {
	List<BourgerModel> findAll();
}
