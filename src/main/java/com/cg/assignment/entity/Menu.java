package com.cg.assignment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int menuId;
	
	private String menu;
	private double price;
	private String menuImg;
	
	
	public Menu(String menu, double price, String menuImg) {
		super();
		this.menu = menu;
		this.price = price;
		this.menuImg = menuImg;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMenuImg() {
		return menuImg;
	}

	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}
	
	
	
}
