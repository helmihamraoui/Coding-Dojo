package com.dojoandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojoandninjas.models.DojoModel;

@Repository
public interface DojoRepository extends CrudRepository<DojoModel,Long> {
	
	List<DojoModel> findAll();

}
