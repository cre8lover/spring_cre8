package com.cre8.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cre8.dto.Creator;
import com.cre8.service.MainlistService;
import com.cre8.service.MainlistServiceImp;


@Controller
@RequestMapping("/main/")
public class Mainlistcontroller {
	
	@Autowired	
    MainlistService main;   
	 
    @GetMapping("productDetail")
    public String detail() {
  
    	return "/buy/DetailClothes";
    }

    @GetMapping("HotCreator")
    public String hot(Model model) {
    	
    	HashMap<String, List<Creator>> hot = main.creList();
	 	List<Creator> hotlist = hot.get("hot");
	 	model.addAttribute("crelist", hotlist);
    	
    	
    	return "/mainlist/HotCreator";
    }
    
    @GetMapping("NewCreator")
    public String new1(Model model) {
    	
    	HashMap<String, List<Creator>> hot = main.creList();
		List<Creator> newlist = hot.get("new");
		model.addAttribute("crelist", newlist);
    	
    	return "/mainlist/NewCreator";
    }	
    
    @GetMapping("Detail")
    public String list(Model model, @RequestParam("memid") String memid) {
    	
		Creator detailList = main.creDetail(memid);
		model.addAttribute("detailList", detailList);
		
		return "/creater/creatorDetail";
    }
 
}
