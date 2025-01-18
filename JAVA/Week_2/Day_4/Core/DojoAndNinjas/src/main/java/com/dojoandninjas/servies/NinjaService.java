package com.dojoandninjas.servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojoandninjas.models.NinjaModel;
import com.dojoandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	NinjaRepository ninjaRepo;
	
	public List<NinjaModel> getAllDojo(){
		return ninjaRepo.findAll();
	}
	public NinjaModel create(NinjaModel newNinja) {
		return ninjaRepo.save(newNinja);
	}
}
