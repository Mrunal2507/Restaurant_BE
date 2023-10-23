package com.cg.assignment.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int restaurantId;
	
	private String resName;
	private String ownerName;
	private String resImg;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="restaurantId")
	private List<Menu>menus;
	

	public Restaurant(String resName, String ownerName, String resImg) {
		super();
		this.resName = resName;
		this.ownerName = ownerName;
		this.resImg = resImg;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getResImg() {
		return resImg;
	}

	public void setResImg(String resImg) {
		this.resImg = resImg;
	}
	
}
