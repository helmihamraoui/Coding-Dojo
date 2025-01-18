package com.dojoandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojoandninjas.models.NinjaModel;
@Repository
public interface NinjaRepository  extends CrudRepository<NinjaModel,Long> {
	List<NinjaModel> findAll();
}
