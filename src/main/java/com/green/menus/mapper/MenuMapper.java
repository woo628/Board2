package com.green.menus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.menus.dto.MenuDTO;

@Mapper
public interface MenuMapper {

	List<MenuDTO> getMenuList();

	void insertMenu(MenuDTO menuDTO);

	void deleteMenu(String menu_id);

	void updateMenu(String menu_id);
	
}




