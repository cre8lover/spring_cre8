package com.cre8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cre8.dto.Pro;
import com.cre8.service.ProService;


@Controller
@RequestMapping("/")
public class Homecontroller{
	
	/*
	 * @Autowired ProService pro;
	 * 
	 * @GetMapping("/") public String home(Model model, List<Pro> prolist) {
	 * 
	 * prolist = pro.proList_clothes(); model.addAttribute("proList", prolist);
	 * 
	 * return "/index"; }
	 */

	@GetMapping("/")
	public String home() {
	
		return "/index";
	}

}
