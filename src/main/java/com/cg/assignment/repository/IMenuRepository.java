package com.cg.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.assignment.entity.Menu;

@Repository
public interface IMenuRepository extends JpaRepository<Menu, Integer>{
	
}

