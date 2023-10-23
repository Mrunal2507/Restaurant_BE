package com.cg.assignment.util;

import org.springframework.stereotype.Component;

import com.cg.assignment.dto.MenuResponseDTO;
import com.cg.assignment.entity.Menu;

@Component
public class MenuDTOConvertor {

	public MenuResponseDTO convertTo(Menu menu) {
		return new MenuResponseDTO(menu.getMenuId(),menu.getMenu(),menu.getPrice(),menu.getMenuImg());
	}
}
