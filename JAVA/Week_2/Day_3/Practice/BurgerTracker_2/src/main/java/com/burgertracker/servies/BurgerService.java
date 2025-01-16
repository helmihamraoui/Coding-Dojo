package com.burgertracker.servies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burgertracker.models.BourgerModel;
import com.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	@Autowired
	BurgerRepository burgerRepo;
	
	public List<BourgerModel> getAllBurgers(){
		return burgerRepo.findAll();
	}
	public BourgerModel createBurger(BourgerModel newBurger) {
		return burgerRepo.save(newBurger);
	}
	public BourgerModel getOneById(long id){
		Optional<BourgerModel> burger= burgerRepo.findById(id);
		if (!burger.isPresent()) {
			return null;
		}
		return burger.get();
	}
	public BourgerModel update(long id,BourgerModel burger) {
		return burgerRepo.save(burger);
	}
}
