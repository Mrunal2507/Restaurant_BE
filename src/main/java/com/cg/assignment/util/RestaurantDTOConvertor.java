package com.cg.assignment.util;

import org.springframework.stereotype.Component;

import com.cg.assignment.dto.RestaurantResponseDTO;
import com.cg.assignment.entity.Restaurant;

@Component
public class RestaurantDTOConvertor {

	public RestaurantResponseDTO convertTo(Restaurant restaurant) {
		
		return new RestaurantResponseDTO(restaurant.getRestaurantId(),restaurant.getResName(), restaurant.getOwnerName(), restaurant.getResImg());
	}
}
