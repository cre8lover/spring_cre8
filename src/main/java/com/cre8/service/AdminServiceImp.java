package com.cre8.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cre8.dao.AdminDao;
import com.cre8.dao.AdminDaoImp;
import com.cre8.dto.Address;
import com.cre8.dto.AdminKeyWord;
import com.cre8.dto.Att;
import com.cre8.dto.Cat;
import com.cre8.dto.Marketing;
import com.cre8.dto.Mem;

@Service
public class AdminServiceImp implements AdminService {
	
	@Autowired
	AdminDao dao;
	
	private static final String CHARSET = "utf-8";

	@Override
	public Map<String, String> login(String id, String pw) {

		return dao.longinProc(id, pw);
	}

	@Override
	public List<Cat> catelist(AdminKeyWord adkey) {
		
		return dao.categorylist(adkey);
	}
/*
	@Override
	public List<Pro> itemlist() {
		
		return dao.itemlist();
	}
*/
	@Override
	public List<Marketing> marketinglist(AdminKeyWord adkey) {
		
		return dao.marketinglist(adkey);
	}

	@Override
	public List<Marketing> month() {
		
		return dao.monthlist();
	}

	@Override
	public List<Marketing> year() {
		return dao.yearlist();
	}

	@Override
	public void reg(Marketing market, HttpServletRequest req) {
/*		
		String cate = req.getParameter("marcate");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String company = req.getParameter("company");
		String start = req.getParameter("start");
		String finish = req.getParameter("finish");
		String comment = req.getParameter("comment");
		String phone = req.getParameter("phone");
		String ceo = req.getParameter("ceo");
		String regnum = req.getParameter("regnum");
		String mobile = phone;
		if(phone.length() == 11) {
			mobile = phone.replaceFirst("(^[0-9]{3})([0-9]{4})([0-9]{4})$","$1-$2-$3");
		}
		market.setMarCategory(cate);
		market.setMarProduct(name);
		market.setMarPrice(price);
		market.setMarCompany(company);
		market.setMarOpendate(start);
		market.setMarClosedate(finish);
		market.setMarDetail(comment);
		market.setMarPhone(mobile);
		market.setMarCeo(ceo);
		market.setMarRegnum(regnum);
*/		
		Mem m = new Mem();
		HttpSession sess = req.getSession();
		String id = (String)sess.getAttribute("sess_id");
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setDefaultCharset(CHARSET);
		ServletFileUpload upload = new ServletFileUpload(factory);

		Address add = new Address();
		Att attachfile = null;
		FileServiceImp fileService = new FileServiceImp();
		
		
		
		try {
			List<FileItem> items =  upload.parseRequest(req);
			for(FileItem item : items) {
				
				if(item.isFormField()) {
					market = fileService.getFormParameter_marketing(item, market, add);
				} else {
					attachfile = fileService.fileUpload(item);
				}
			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		m.setMemId(id);
		attachfile.setMem(m);
		
		market.setAttSet(attachfile);
		dao.marketReg( market);
	}

	@Override
	public List<Mem> memberlist(AdminKeyWord adkey) {

	   return dao.memberlist(adkey);
	}

	@Override
	public List<Marketing> purchase(AdminKeyWord adkey) {

		return dao.buylist(adkey);
	}

	@Override
	public Marketing modify(String seqno) {
		
		return dao.modify(seqno);
	}
/*
	public void update(HttpServletRequest req) {
		Marketing market = new Marketing();
		
		String o = req.getParameter("seqno");
		int seqno = Integer.parseInt(o);
		
		String cate = req.getParameter("marcate");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String company = req.getParameter("company");
		String start = req.getParameter("start");
		String finish = req.getParameter("finish");
		String comment = req.getParameter("comment");
		String phone = req.getParameter("phone");
		String ceo = req.getParameter("ceo");
		String regnum = req.getParameter("regnum");
		String mobile = phone;
		if(phone.length() == 11) {
			mobile = phone.replaceFirst("(^[0-9]{3})([0-9]{4})([0-9]{4})$","$1-$2-$3");
			}
		market.setMarCategory(cate);
		market.setMarProduct(name);
		market.setMarPrice(price);
		market.setMarCompany(company);
		market.setMarOpendate(start);
		market.setMarClosedate(finish);
		market.setMarDetail(comment);
		market.setMarPhone(mobile);
		market.setMarCeo(ceo);
		market.setMarRegnum(regnum);
		market.setMarSeqno(seqno);
		dao.update(market);
	}
*/
}
