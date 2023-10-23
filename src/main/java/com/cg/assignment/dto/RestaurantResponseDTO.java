package com.cg.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantResponseDTO {

	private int restaurantId;
	private String resName;
	private String ownerName;
	private String resImg;
	
//	public RestaurantResponseDTO(String resName, String ownerName, String resImg) {
//		super();
//		this.resName = resName;
//		this.ownerName = ownerName;
//		this.resImg = resImg;
//	}
	
	
}
