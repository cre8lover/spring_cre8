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
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf8");
		req.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		String path = req.getContextPath();
		
		ProServiceImp proservice = new ProServiceImp();
		if(cmd.equals("clothes")) {
			List<Pro> prolist1 = pro.proList_clothes();
			req.setAttribute("proList", prolist1);
			goView(req, resp, "/listimg/product_clothes.jsp");
			
		} else if(cmd.equals("furniture")) {
			List<Pro> prolist2 = pro.proList_furn();
			req.setAttribute("proList", prolist2);
			goView(req, resp, "/listimg/product_furniture.jsp");
			
		} else if(cmd.equals("cosmetics")) {
			List<Pro> prolist3 = pro.proList_cos();
			req.setAttribute("proList", prolist3);
			goView(req, resp, "/listimg/product_cosmetics.jsp");
			
			
		} else if(cmd.equals("interior")) {
			List<Pro> prolist4 = pro.proList_interior();
			req.setAttribute("proList", prolist4);
			goView(req, resp, "/listimg/product_interior.jsp");
			
		} else if(cmd.equals("travel")) {
			List<Pro> prolist5 = pro.proList_tra();
			req.setAttribute("proList", prolist5);
			goView(req, resp, "/listimg/product_travel.jsp");
			
		} else if(cmd.equals("productDetail")) {
//			System.out.println("?ÑúÎ∏îÎ¶ø ?ôï?ù∏" );
			String seqno = req.getParameter("seqno");
			
			if (seqno == null) {
				seqno = (String) req.getAttribute("seqno");
			}
			
			req.setAttribute("detailList", pro.detailList(seqno));
			goView(req, resp, "/buy/DetailClothes.jsp");
			
		}
			
	}

	private void goView(HttpServletRequest req, HttpServletResponse resp, String viewPage) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);		
	}

}
