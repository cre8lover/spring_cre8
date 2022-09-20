package com.cre8.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.cre8.dto.Auc;
import com.cre8.dto.Creator;
import com.cre8.dto.Marketing;
import com.cre8.dto.Pro;


public interface CreatorService {
	
	void Creatoradd(Creator cre);
	
	public List<Creator> Creatorpage();
	
	public List<Pro> salesHistory(String id);
	
	Map<String, List<Pro>> calculate(String id);
	
	void CreatorName(String id);
	
	List<Marketing> mk();
	
	public Marketing mkk(int seqno);
	
	List<Pro> Prolist(String seqno, String id);
	
	List<Auc> Auclist(String seqno, String id);
	
	public Creator infomodify(String id);

	String totalmoney(String id);
	
	String aucadd(MultipartFile filename, Auc auc);

	   Auc aucdetail(String seqno);
	
	public Pro productdetail(String seqno);

	String productadd(HttpServletRequest req);

	Map<String, String> cremodifyreg(HttpServletRequest req);

	public void prodel(String seqno);

}
