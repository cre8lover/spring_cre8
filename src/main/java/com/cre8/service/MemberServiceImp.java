package com.cre8.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cre8.dao.MemberDaoImp;
import com.cre8.dto.Address;
import com.cre8.dto.Att;
import com.cre8.dto.Cart;
import com.cre8.dto.Mem;
import com.cre8.dto.Pro;
import com.cre8.dto.Ship;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	MemberDaoImp dao;
	
	private static final String CHARSET = "utf-8";

	@Override
	public Map<String, String> login(String id, String pw) {
		
		return dao.longinProc(id, pw);
	}

	@Override
	public String insert(Mem mem) {
//		mem = new Mem();
//		
//		String id = req.getParameter("id");
//		String pw = req.getParameter("pw");
//		String name = req.getParameter("name");
//		String birth = req.getParameter("birth");
//		String email = req.getParameter("email");
//		String mobile = req.getParameter("mobile");
//		String agree = req.getParameter("check");
//		String phone = mobile;
//		if(mobile.length() == 11) {
//		  phone = mobile.replaceFirst("(^[0-9]{3})([0-9]{4})([0-9]{4})$","$1-$2-$3");
//		} 
//		mem.setMemId(id);
//		mem.setMemPw(pw);
//		mem.setMemName(name);
//		mem.setMemBirth(birth);
//		mem.setMemEmail(email);
//		mem.setMemTel(phone);
//		mem.setCheck(agree);
		return dao.reginsert(mem);
	}

	@Override
	public Mem mypage(String id) {
		
		return dao.mypage(id);
	}
	
	@Override
	public Mem meminfo(String id) {

		return dao.info(id);
	}

	@Override
	public List<Pro> membuylist(String id) {
		
		return dao.membuylist(id);
	}

	@Override
	public Map<String, List<Cart>> memauclist(String id) {
		
		return dao.memauclist(id);
	}

	@Override
	public List<Pro> buystat(String id) {
		
		return dao.buystat(id);
	}

	@Override
	public Map<String, List<Ship>> ordercheck(String id) {

		return dao.ordercheck(id);
	}

	@Override
	public void infoinsert(Mem mem, HttpServletRequest req) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		factory.setDefaultCharset(CHARSET);
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		HttpSession sess = req.getSession();
		/*
		String id = (String)sess.getAttribute("sess_id");
		mem.setMemId(id);
		
		String phone = req.getParameter("phone");
		String eamil = req.getParameter("eamil");
		String sns = req.getParameter("sns");
		
		mem.setMemTel(phone);
		mem.setMemEmail(eamil);
		mem.setMemSnsinfo(sns);
		
		String cate = req.getParameter("cate");
		String mobile = req.getParameter("mobile");
		String person = req.getParameter("person");
		String address = req.getParameter("address");
		String detail = req.getParameter("address_detail");
		
		Address add = new Address();

		add.setAddCategory(cate);
		add.setAddPhone(mobile);
		add.setAddPerson(person);
		add.setAddAddress(address);
		add.setAddetail(detail);
		
		mem.setAddressSet(add);
		
		*/
		Address add = new Address();
		Att attachfile = null;
		FileServiceImp fileService = new FileServiceImp();
		
		try {
			List<FileItem> items =  upload.parseRequest(req);
			for(FileItem item : items) {
				
				if(item.isFormField()) {
					mem = fileService.getFormParameter_mypage(item, mem, add);
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
		mem.setAtt(attachfile);
		String id = (String)sess.getAttribute("sess_id");
		mem.setMemId(id);
		dao.infoinsert(mem);	
	}
	
	@Override
	public Map<String, String> changePw(String new_pw, String id, String now_pw) {
		
		return dao.changePw(new_pw, id, now_pw);
	}

	@Override
	public Map<String, String> findId(String idemail) {
		
		return dao.findId(idemail);
	}

	@Override
	public Map<String, String> findPw(String id, String email) {

		return dao.findPw(id, email);
	}

	@Override
	public int idcheck(String id) {

		return dao.checkid(id);
	}

}
