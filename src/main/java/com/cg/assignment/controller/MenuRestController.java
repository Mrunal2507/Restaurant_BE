package com.cg.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.assignment.dto.MenuResponseDTO;
import com.cg.assignment.entity.Menu;
import com.cg.assignment.service.IMenuService;
import com.cg.assignment.service.IRestaurantService;
import com.cg.assignment.util.MenuDTOConvertor;
import com.cg.assignment.util.RestaurantDTOConvertor;

@Controller
@RestController
@RequestMapping("/menu")
@CrossOrigin(origins = {"http://localhost:4200/","http:localhost:8080/"}, allowedHeaders="*")
public class MenuRestController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IMenuService menuService;
	
	@Autowired
	MenuDTOConvertor dtoConvertor;
	
	@Autowired
	IRestaurantService restaurantService;
	
	@Autowired
	RestaurantDTOConvertor resdtoConvertor;
	
	public MenuRestController() {
		logger.info(" Menu Rest Controller Called");
		System.err.println("-------Menu Rest Controller Called-------");
	}

	
	@PostMapping("/add")
	public ResponseEntity<MenuResponseDTO> saveMenu(@RequestBody Menu menu) {

		Menu savedMenu = menuService.addMenu(menu);
		logger.info("Menu Saved" + savedMenu);

		MenuResponseDTO dto = dtoConvertor.convertTo(savedMenu);

		return new ResponseEntity<MenuResponseDTO>(dto, HttpStatus.OK);

	}
	
	@DeleteMapping("/{menuId}")
	public void removeMenu(@PathVariable int menuId) {
		menuService.deleteMenu(menuId);
	}
	
	@PutMapping("/edit")
	public Menu updateMenu(@RequestBody Menu menu) {
		return menuService.editMenu(menu);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<MenuResponseDTO>> getAllMenus(){
		List<Menu> allMenus = menuService.getAllMenu();
		List<MenuResponseDTO> dtoList = new ArrayList<>();
		
		for(Menu menu: allMenus) {
			MenuResponseDTO dtoObj = dtoConvertor.convertTo(menu);
			dtoList.add(dtoObj);
		}
		return new ResponseEntity<List<MenuResponseDTO>>(dtoList, HttpStatus.OK);
	}
	
	@PutMapping("/{menuId}/assign/{restaurantId}")
	public ResponseEntity<MenuResponseDTO>updateResByMenu(@PathVariable int menuId, @PathVariable int restaurantId) {
		Menu updatedMenu = menuService.updateRestaurantByMenu(menuId, restaurantId);
		if(updatedMenu != null) {
			MenuResponseDTO dto = dtoConvertor.convertTo(updatedMenu);
			return new ResponseEntity<MenuResponseDTO>(dto, HttpStatus.OK);
		}
		return null;
	}
	
}
