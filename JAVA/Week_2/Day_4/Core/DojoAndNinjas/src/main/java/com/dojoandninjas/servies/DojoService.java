package com.dojoandninjas.servies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojoandninjas.models.DojoModel;
import com.dojoandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	DojoRepository dojoRepo;
	//get all dojo
	public List<DojoModel> getAllDojo(){
		return dojoRepo.findAll();
	}
	public DojoModel create(DojoModel newdojo) {
		return dojoRepo.save(newdojo);
	}
	public DojoModel getDojoById(Long id) {
		Optional<DojoModel> d=dojoRepo.findById(id);
		if(d.isEmpty()) {
			return null;
		}
		return d.get();
	}
}
