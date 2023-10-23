package com.cg.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.assignment.entity.Menu;

@Service
public interface IMenuService {
	
	public Menu addMenu(Menu menu);
	
	public Menu editMenu(Menu menu);
	
	public void deleteMenu(int menuId);
	
	public List<Menu> getAllMenu();
	
	public Menu updateRestaurantByMenu(int menuId, int restaurantId);

}
