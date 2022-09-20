package com.cre8.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cre8.dao.CreatorDao;
import com.cre8.dto.Att;
import com.cre8.dto.Auc;
import com.cre8.dto.Creator;
import com.cre8.dto.Item;
import com.cre8.dto.Marketing;
import com.cre8.dto.Pro;



@Service
public class CreatorServiceImp implements CreatorService{
	
	
	private static final String CHARSET = "utf-8";
	
	@Autowired
	CreatorDao creatorDao;
	
	@Override
	public void Creatoradd(Creator cre) {
		creatorDao.Creatoradd(cre);
	}

	@Override
	public List<Creator> Creatorpage() {
		return creatorDao.Creatorpage();
	}

	@Override
	public List<Pro> salesHistory(String id) {
		return creatorDao.salesHistory(id);
	}
	
	@Override
	public Map<String, List<Pro>> calculate(String id) {
		// TODO Auto-generated method stub
		return creatorDao.calculate(id);
	}
	
	@Override
	public void CreatorName(String id) {
		creatorDao.CreatorName(id);
	}

	@Override
	public List<Marketing> mk() {
		return creatorDao.mk();
	}

	@Override
	public List<Pro> Prolist(String seqno, String id) {
		return creatorDao.Prolist(seqno,id);
	}

	@Override
	public List<Auc> Auclist(String seqno, String id) {
		return creatorDao.Auclist(seqno,id);
	}

	
	@Override
	   public Creator infomodify(String id) {
	      return creatorDao.infomodify(id);
	}
	@Override
	public String totalmoney(String id) {
		return creatorDao.totalmoney(id);
	}

	@Override
	public Pro productdetail(String seqno) {
	  
		return creatorDao.productdetail(seqno);
	}
	
	
	@Override
    public String aucadd(MultipartFile filename, Auc auc) {
		
		FileService fileService = new FileServiceImp();
		Att attachfile=null;
		
		try {
			attachfile = fileService.fileUpload(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		auc.setAtt_file(attachfile);
	    
	    if (auc.getAucSeqno() != null) {
	    	return creatorDao.aucmodify(auc);
	    }else {
	    	return creatorDao.aucadd(auc, auc.getId());
	    }
		
    }
	
	
	
    @Override
    public Auc aucdetail(String seqno) {
    	return creatorDao.aucdetail(seqno);
    }

	@Override
	public Marketing mkk(int seqno) {
		return creatorDao.mkk(seqno);
	}
	
	@Override
	   public String productadd(HttpServletRequest req) {
		
		DiskFileItemFactory factory = new DiskFileItemFactory(); 
		factory.setDefaultCharset("CHARSET");//?��?���? ?��?��?��?���? 좋다.
		//factory form?�� ?��?��?���? �??��???�� ???�� utf8�? ???��?��?���? 좋음
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		
		
		
		Pro pro = new Pro();
		Item proitem = new Item();
		Att attachfile = null;
		FileService fileService = new FileServiceImp();
		
		try {
			List<FileItem> items = upload.parseRequest(req);
			//�??��?��?�� ?��?���?
			for(FileItem item : items) {
				if (item.isFormField()) {//2진데?��?��?���? ?��?��?��?���? 구별?���?
					pro =  fileService.getFormParameter(item,pro,proitem); 
				}else {
					attachfile = fileService.fileUpload(item);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pro.setAtt_file(attachfile);
	    String id = (String)req.getSession().getAttribute("sess_id");
	    if(pro.getProSeqno() != null) return creatorDao.productmodify(pro);
	    else return creatorDao.productadd(pro,id);
	      
	   }
	
	@Override
	   public Map<String, String> cremodifyreg(HttpServletRequest req) {
	      return creatorDao.cremodifyreg(req);
	   }
	@Override
	public void prodel(String seqno) {
		FileService fileservice = new FileServiceImp();
		Att att = creatorDao.prodel(seqno);

		fileservice.delete(null,att.getSavefilename(),att.getAttPath(),att.getAttThumb().getFileName());
	}
	

}











