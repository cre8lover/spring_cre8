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
import org.springframework.web.multipart.MultipartFile;

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
	@Autowired 
	FileService fileService;
	
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
	public void reg(Marketing market, MultipartFile filename, String id) {
		Mem m = new Mem();
		Att attachfile = null;
		
		
		
		try {
			if(filename != null) {
				attachfile = fileService.fileUpload(filename);
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		m.setMemId(id);
		attachfile.setMem(m);
		
		market.setAttSet(attachfile);
		dao.marketReg(market);
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
}
