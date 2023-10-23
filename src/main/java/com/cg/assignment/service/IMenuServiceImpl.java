package com.cg.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.assignment.entity.Menu;
import com.cg.assignment.entity.Restaurant;
import com.cg.assignment.repository.IMenuRepository;
import com.cg.assignment.repository.IRestaurantRepository;

@Service
public class IMenuServiceImpl implements IMenuService{
	
	@Autowired
	IMenuRepository menuRepository;
	
	@Autowired
	IRestaurantRepository resRepository;
	
	@Override
	public Menu addMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuRepository.save(menu);
	}

	@Override
	public Menu editMenu(Menu menu) {
		// TODO Auto-generated method stub
		return menuRepository.save(menu);
	}

	@Override
	public void deleteMenu(int menuId) {
		// TODO Auto-generated method stub
		menuRepository.deleteById(menuId);
	}
	
	@Override
	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		return menuRepository.findAll();
	}

	@Override
	public Menu updateRestaurantByMenu(int menuId, int restaurantId) {
		// TODO Auto-generated method stub
		Menu menuDB = menuRepository.getReferenceById(menuId);
		Restaurant resBD = resRepository.getReferenceById(restaurantId);
		
		if(menuDB != null & resBD != null) {
			List<Menu> allMenus = resBD.getMenus();
			
			if(allMenus != null && allMenus.isEmpty()==false) {
				allMenus.add(menuDB);
				resBD.setMenus(allMenus);
			}
			else {
				List<Menu> newMenuList = new ArrayList<>();
				newMenuList.add(menuDB);
				resBD.setMenus(newMenuList);
			}
			resRepository.saveAndFlush(resBD);
			menuRepository.save(menuDB);
			return menuDB;
		}
		else
		return null;
	}

}
