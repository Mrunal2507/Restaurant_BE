package com.cg.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.assignment.entity.Menu;
import com.cg.assignment.entity.Restaurant;
import com.cg.assignment.repository.IRestaurantRepository;

@Service
public class IRestaurantServiceImpl implements IRestaurantService{

	@Autowired
	IRestaurantRepository restaurantRepository;

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant editRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return restaurantRepository.save(restaurant);
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		restaurantRepository.deleteById(restaurantId);
	}
	
	@Override
	public List<Restaurant> getAllRestaurant() {
		// TODO Auto-generated method stub
		return restaurantRepository.findAll();
	}

	@Override
	public List<Restaurant> getResByOwnerName(String ownerName) {
		// TODO Auto-generated method stub
		return restaurantRepository.getResByOwnerName(ownerName);
	}

	@Override
	public List<Menu> getMenuByRestaurantName(String resName) {
		// TODO Auto-generated method stub
		return restaurantRepository.getMenuByRestaurantName(resName);
	}
	
}
