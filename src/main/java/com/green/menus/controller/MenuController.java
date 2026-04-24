package com.green.menus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.menus.dto.MenuDTO;
import com.green.menus.mapper.MenuMapper;

@Controller
public class MenuController {
	
	@Autowired
	private  MenuMapper  menuMapper;
	
	// 메뉴 목록 조회  http://localhost:9090/Menus/List
	@RequestMapping("/Menus/List")   
	public   String   list(Model model) {
		// 조회한결과를 ArrayList 로 돌려준디
		List<MenuDTO> menuList = menuMapper.getMenuList();
//		System.out.println(menuList);
		
		model.addAttribute("menuList",menuList);
		
		return "menus/list";
	}
	
	@RequestMapping("/Menus/WriteForm")
	public String writeform() {
		return "menus/write";
	}
	
	@RequestMapping("/Menus/Write")
//	public String write(String menu_id, String menu_name, int menu_seq) {
	public String write(MenuDTO menuDTO, Model model) {
		
		// 넘어온 값
//		System.out.println(menuDTO.getMenu_id());
//		System.out.println(menuDTO.getMenu_name());
//		System.out.println(menuDTO.getMenu_seq());
				
		// db 저장
		menuMapper.insertMenu(menuDTO);
		
		// 다시 조회 -> menuList
		List<MenuDTO> menuList = menuMapper.getMenuList();
		model.addAttribute("menuList",menuList);
		
		return "menus/list";
	}
	
	@RequestMapping("/Menus/Delete")
//	public String delete(@RequestParam("menu_id") String menu_id, Model model) {
	public String delete(@RequestParam("menu_id") String menu_id) {
		
		System.out.println(menu_id);
		menuMapper.deleteMenu(menu_id);
		
	//	List<MenuDTO> menuList = menuMapper.getMenuList();
	//	model.addAttribute("menuList",menuList);
		
	//	return "menus/list";
		return "redirect:/Menus/List";
	}
	
	@RequestMapping("/Menus/Update")
	public String update(@RequestParam("menu_id") String menu_id) {
		
		System.out.println(menu_id);
		menuMapper.updateMenu(menu_id);
		
		return "menus/update";
	}
	
}













