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

import com.cre8.dto.Creator;
import com.cre8.service.MainlistServiceImp;


@WebServlet("/main/*")
public class Mainlistcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MainlistServiceImp main = new MainlistServiceImp();   
	
    public Mainlistcontroller() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doAction(req, resp);
	}

	private void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf8");
		req.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		String path = req.getContextPath();
		
		if(cmd.equals("productDetail")) {
			goView(req, resp, "/buy/DetailClothes.jsp");
			
		} else if(cmd.equals("HotCreator")) {
			HashMap<String, List<Creator>> hot = main.creList();
		 	List<Creator> hotlist = hot.get("hot");
		 	req.setAttribute("crelist", hotlist);
		 	goView(req, resp, "/mainlist/HotCreator.jsp");

		} else if(cmd.equals("NewCreator")) {
			HashMap<String, List<Creator>> hot = main.creList();
			List<Creator> newlist = hot.get("new");
			req.setAttribute("crelist", newlist);
			goView(req, resp, "/mainlist/NewCreator.jsp");
		
		}
		
	}

	private void goView(HttpServletRequest req, HttpServletResponse resp, String viewPage) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);		
	}

}
