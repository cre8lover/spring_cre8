package com.cre8.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cre8.dto.Cart;
import com.cre8.dto.Pro;
import com.cre8.service.ProService;
import com.cre8.service.ProServiceImp;

@Controller
@RequestMapping("/product/")
public class Productcontroller extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   @Autowired
   ProService pro;

    @GetMapping("clothes") 
    public String clothes(Model model) {
       List<Pro> prolist1 = pro.proList_clothes();
       model.addAttribute("proList", prolist1);
       
       return "/listimg/product_clothes";
    }
   
    @GetMapping("furniture")
    public String furniture(Model model) {
       List<Pro> prolist2 = pro.proList_furn();
      model.addAttribute("proList", prolist2);
      
      return "/listimg/product_furniture";
    } 
    
   
    @GetMapping("cosmetics")
    public String cos(Model model) {
       List<Pro> prolist3 = pro.proList_cos();
       model.addAttribute("proList", prolist3);
       
       return "/listimg/product_cosmetics";
    }
    
    @GetMapping("interior")
    public String interior(Model model) {
       List<Pro> prolist4 = pro.proList_interior();
       model.addAttribute("proList", prolist4);
       
       return "/listimg/product_interior";
    }
    
    @GetMapping("travel")
    public String travel(Model model) {
       List<Pro> prolist5 = pro.proList_tra();
       model.addAttribute("proList", prolist5);
       
       return "/listimg/product_cosmetics";
    }
    
    
    
    @GetMapping("productDetail")
    public String detail(@ModelAttribute("seqno") String seqno,Model model) {
    		
    	Pro detailList = pro.detailList(seqno);
    	model.addAttribute("detailList",detailList);
    	
    	return "/buy/DetailClothes";
    }

    @GetMapping("nowbuy")
    public String nowbuy (@ModelAttribute("seqno") String seqno,@ModelAttribute("amount") String amount,Model model) {
    	
    	List<Cart> prolist = pro.nowbuy(seqno,amount);
    	model.addAttribute("cartp", prolist);
		return "/buy/buylist";
    }
    
    
    
}