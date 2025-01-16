package com.savetravels.servies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savetravels.models.TravelModel;
import com.savetravels.repositories.TravelRepository;

@Service
public class TravelServies {
	@Autowired
	TravelRepository travelRepo;
	public List<TravelModel> getAllTravel(){
		return travelRepo.findAll();
	}
	public TravelModel createTravel(TravelModel newTravel) {
		return travelRepo.save(newTravel);
	}
	public TravelModel getOneById(long id){
		Optional<TravelModel> travel= travelRepo.findById(id);
		if (!travel.isPresent()) {
			return null;
		}
		return travel.get();
	}
	public TravelModel update(long id,TravelModel travel) {
		travel.setId(id);
		return travelRepo.save(travel);
	}
	public void delete(long id) {
		travelRepo.deleteById(id);
	}
}
