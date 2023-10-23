package com.cg.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.assignment.entity.Menu;
import com.cg.assignment.entity.Restaurant;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer>{

	public List<Restaurant> getResByOwnerName(String ownerName);
	
	@Query("SELECT m FROM Restaurant r JOIN r.menus m WHERE r.resName = :resName")
	public List<Menu> getMenuByRestaurantName(@Param("resName") String resName);
}
