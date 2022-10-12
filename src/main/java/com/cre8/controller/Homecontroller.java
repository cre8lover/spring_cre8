package com.cre8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.Pro;
import com.cre8.service.ProService;


@Controller
@RequestMapping("/")
public class Homecontroller{
	
	@Autowired 
	ProService pro;
	
	@GetMapping("/")
	public String home(Model model) {
		Auc_Criteria ac = new Auc_Criteria();
		int random = (int) Math.floor((Math.random()*5)+1);
		ac.setCategory(""+random);
		List<Pro> prolist = pro.proList_clothes(ac); 
		model.addAttribute("proList", prolist);
		
		return "/index";
	}

}
