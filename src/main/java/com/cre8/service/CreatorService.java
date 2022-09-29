package com.cre8.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.cre8.dto.Att;
import com.cre8.dto.Auc;
import com.cre8.dto.Creator;
import com.cre8.dto.Marketing;
import com.cre8.dto.Pro;
import com.cre8.dto.prodelVo;


public interface CreatorService {
	
	void Creatoradd(HttpServletRequest request, String id);
	
	public List<Creator> Creatorpage();
	
	public List<Pro> salesHistory(String id);
	
	Map<String, List<Pro>> calculate(String id);
	
	void CreatorName(String id);
	
	List<Marketing> mk();
	
	public Marketing mkk(int seqno);
	
	List<Pro> Prolist(String seqno, String id);
	
	List<Auc> Auclist(String seqno, String id);
	
	public int infomodify(Creator c);

	String totalmoney(String id);
	
	String aucadd(HttpServletRequest req);

	   Auc aucdetail(String seqno);
	
	public Pro productdetail(String seqno);

	String productadd(Pro pro,MultipartFile filename, String string);

	Map<String, String> cremodifyreg(HttpServletRequest req);

	String aucadd(MultipartFile filename, Auc auc);

	int prodel(prodelVo seqno);

	List<Marketing> getList();

	int prodel(String seqno);



}
