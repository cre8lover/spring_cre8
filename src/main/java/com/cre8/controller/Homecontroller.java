package com.cre8.controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cre8.dto.Pro;
import com.cre8.service.ProService;
import com.cre8.service.ProServiceImp;


@WebServlet("/")
public class Homecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProService pro = new ProServiceImp();
    public Homecontroller() {
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
		
//		String uri = req.getRequestURI();
//		String cmd = uri.substring(uri.lastIndexOf("/")+1);
//		String path = req.getContextPath();
		
		ServletContext ctx = getServletContext();
			List<Pro> prolist1 = pro.proList_clothes();
			ctx.setAttribute("proList", prolist1);
			goView(req, resp, "/index.jsp");
	}

	private void goView(HttpServletRequest req, HttpServletResponse resp, String viewPage) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);		
	}

}
