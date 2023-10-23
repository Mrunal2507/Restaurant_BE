package com.cg.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.assignment.dto.RestaurantResponseDTO;
import com.cg.assignment.entity.Menu;
import com.cg.assignment.entity.Restaurant;
import com.cg.assignment.service.IRestaurantService;
import com.cg.assignment.util.RestaurantDTOConvertor;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin(origins = {"http://localhost:4200/","http:localhost:8080/"}, allowedHeaders="*")
public class RestaurantRestController {

private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	IRestaurantService restaurantService;
	
	@Autowired
	RestaurantDTOConvertor dtoConvertor;
	
	public RestaurantRestController() {
		logger.info(" Restaurant Rest Controller Called");
		System.err.println("-------Restaurant Rest Controller Called-------");
	}
	
	@PostMapping("/add")
	public ResponseEntity<RestaurantResponseDTO> saveRestaurant(@RequestBody Restaurant restaurant) {

		Restaurant savedRestaurant = restaurantService.addRestaurant(restaurant);
		logger.info("Restaurant Saved" + savedRestaurant);

		RestaurantResponseDTO dto = dtoConvertor.convertTo(savedRestaurant);

		return new ResponseEntity<RestaurantResponseDTO>(dto, HttpStatus.OK);

	}
	
	@DeleteMapping("/{restaurantId}")
	public void removeRestaurant(@PathVariable int restaurantId) {
		restaurantService.deleteRestaurant(restaurantId);
	}
	
	@PutMapping("/edit")
	public Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantService.editRestaurant(restaurant);
	}
	
	@GetMapping("/owner/{ownerName}")
	public ResponseEntity<List<RestaurantResponseDTO>>viewResbyOwnerName(@PathVariable String ownerName){
		List<Restaurant>allRestaus = restaurantService.getResByOwnerName(ownerName);
		List<RestaurantResponseDTO>objDTO = new ArrayList<>();
		
		for(Restaurant restaurant:allRestaus) {
			objDTO.add(dtoConvertor.convertTo(restaurant));
		}
		
		return new ResponseEntity<List<RestaurantResponseDTO>>(objDTO, HttpStatus.OK);
	}
	
	@GetMapping("/{resName}/menu")
	public ResponseEntity<List<Menu>> viewMenuByRestaurantName(@PathVariable String resName) {
	    List<Menu> menus = restaurantService.getMenuByRestaurantName(resName);
	    return new ResponseEntity<>(menus, HttpStatus.OK);
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<RestaurantResponseDTO>> getAllRestaurants(){
		List<Restaurant> allRestaurants = restaurantService.getAllRestaurant();
		List<RestaurantResponseDTO> dtoList = new ArrayList<>();
		
		for(Restaurant restaurant: allRestaurants) {
			RestaurantResponseDTO dtoObj = dtoConvertor.convertTo(restaurant);
			dtoList.add(dtoObj);
		}
		return new ResponseEntity<List<RestaurantResponseDTO>>(dtoList, HttpStatus.OK);
	}
}
