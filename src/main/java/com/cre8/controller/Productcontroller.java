package com.cre8.controller;

import javax.servlet.http.HttpServlet;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.Cart;
import com.cre8.dto.Pro;
import com.cre8.service.ProService;

@Controller
@RequestMapping("/product/")
public class Productcontroller extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   @Autowired
   ProService pro;

    @GetMapping("/cate/{category}") 
    public String clothes(Model model,Auc_Criteria ac) {
//    	System.out.println(ac.getCategory());
//       List<Pro> prolist1 = pro.proList_clothes(ac);
//       model.addAttribute("proList", prolist1);
       model.addAttribute("category", ac.getCategory());
       return "/listimg/product_clothes";
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