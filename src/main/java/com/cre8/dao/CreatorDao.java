package com.cre8.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.cre8.dto.Att;
import com.cre8.dto.Auc;
import com.cre8.dto.Creator;
import com.cre8.dto.Marketing;
import com.cre8.dto.Mem;
import com.cre8.dto.Pro;
import com.cre8.dto.prodelVo;

public interface CreatorDao {

	public void Creatoradd(HttpServletRequest request, String id);
	
	public Mem CreatorName(String id);
	
	public List<Marketing> mk();
	
	public Marketing mkk(int seqno);
	
	public List<Creator> Creatorpage();
	
	public Map<String, String> cremodifyreg(HttpServletRequest req);
	
	public List<Pro> salesHistory(String id);
	
	public Map<String, List<Pro>> calculate(String id);
	
	public List<Pro> Prolist(String seqno,String id );
	
	public List<Auc> Auclist(String seqno, String id);
	
	public Creator infomodify(Creator c);
	
	public String totalmoney(String id);
	
	public Pro productdetail(String seqno);
	
	public String aucadd(Auc auc, String id);
	
	public Auc aucdetail(String seqno);
	
	public String aucmodify(Auc auc);
	
	public String productmodify(Pro pro);
	
	public String productadd(Pro pro, String id);
	
	public Att prodel(prodelVo seqno);
	
}







