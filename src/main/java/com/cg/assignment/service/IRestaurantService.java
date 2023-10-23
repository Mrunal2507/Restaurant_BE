package com.cg.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.assignment.entity.Menu;
import com.cg.assignment.entity.Restaurant;

@Service
public interface IRestaurantService {
	
	public Restaurant addRestaurant(Restaurant restaurant);
	
	public Restaurant editRestaurant(Restaurant restaurant);
	
	public void deleteRestaurant(int restaurantId);
	
	public List<Restaurant> getAllRestaurant();
	
	public List<Restaurant> getResByOwnerName(String ownerName);
	
	public List<Menu> getMenuByRestaurantName(String resName);

}
