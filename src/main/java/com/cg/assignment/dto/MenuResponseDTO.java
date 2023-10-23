package com.cg.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponseDTO {

	private int menuId;
	private String menu;
	private double price;
	private String menuImg;
	
//	public MenuResponseDTO(String menu, double price, String menuImg) {
//		super();
//		this.menu = menu;
//		this.price = price;
//		this.menuImg = menuImg;
//	}	
	
}
