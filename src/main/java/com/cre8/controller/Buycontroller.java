package com.cre8.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cre8.dto.Cart;
import com.cre8.dto.Orders;
import com.cre8.dto.orderadd;
import com.cre8.service.BuyServiceimp;



@Controller
@RequestMapping("/buyer/")
public class Buycontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Autowired
	BuyServiceimp buy;
    
//    @RequestMapping("cart")
//	public String cart(HttpSession sess,HttpServletRequest req,Model model){
//       
//		String orderbutton = req.getParameter("orderbutton");
//		
//		String[] chklist =  req.getParameterValues("allponecheck");
//    	
//			List<Cart> prolist = buy.myCart((String) sess.getAttribute("sess_id"),chklist);
//			
//			if(prolist != null) {
//				model.addAttribute("cartp", prolist);
//			}
//
//			if (orderbutton != null) {
//				return "/buy/buylist";
//			} else {
//				return "/buy/cart";
//			}
//    }	
    @RequestMapping("cart")
	public String cart(HttpSession sess,@ModelAttribute("allponecheck")ArrayList<String> chklist,
						@ModelAttribute("orderbutton")String orderbutton,Model model){
    	
//    	System.out.println("chk"+chklist.size());
//    	System.out.println("or"+orderbutton);
    	if (chklist.size() != 0) {
//    	System.out.println(chklist.get(0));
    	}
			List<Cart> prolist = buy.myCart((String) sess.getAttribute("sess_id"),chklist);
			
			if(prolist != null) {
				model.addAttribute("cartp", prolist);
			}
			
			if (orderbutton.equals("1")) {
				return "/buy/buylist";
			} else {
				return "/buy/cart";
			}
    }	
    
    @RequestMapping("buy")
    public String buy(Model model,@RequestParam("seqno")String o_seqno,
    					HttpSession sess) {
		List<Orders> prolist = buy.orderlist((String) sess.getAttribute("sess_id"), o_seqno);
		if(prolist != null) {
		model.addAttribute("cartp", prolist);
		}
		return "/buy/buy" ;
    	
    }
			
	@RequestMapping("order")
	public void order(orderadd orderadd,HttpServletResponse resp,HttpSession sess) throws IOException {
		orderadd.setId((String) sess.getAttribute("sess_id"));
		int rs = buy.orderand(orderadd);
        String seqno = String.valueOf(rs);
        PrintWriter out = resp.getWriter();
        out.print(seqno);
	}
	
}
