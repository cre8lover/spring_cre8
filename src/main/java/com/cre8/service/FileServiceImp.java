package com.cre8.service;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

import dao.FileDao;
import dto.Address;
import dto.Att;
import dto.Auc;
import dto.Item;
import dto.Marketing;
import dto.Mem;
import dto.Pro;
import dto.Thumbnail;
import net.coobird.thumbnailator.Thumbnails;

public class FileServiceImp implements FileService {

	
	
	@Override
	public Att fileUpload(FileItem item) throws Exception {
		//Ï≤®Î??åå?ùº : Î∞îÏù¥?ÑàÎ¶¨Ìåå?ùº
		long fileSize = item.getSize();
		Att attachfile = null;
		//System.out.println("?óÖÎ°úÎìú ?åå?ùº ?Ç¨?ù¥Ï¶?:" + fileSize);	
		if(fileSize > 0) {
			
			String fileUploadPath = "D:/jmh/upload/";
			String fileName = item.getName();
			// ?ùº?ù¥Î∏åÎü¨Î¶¨Ïù¥?ö©
//			System.out.println(FilenameUtils.getExtension(fileName)); 
//			System.out.println(FilenameUtils.getBaseName(fileName));
			
			//?ÑúÎ∏åÏä§?ã∞Îß? ?ù¥?ö©
			String split_fileName = fileName.substring(0,fileName.lastIndexOf("."));
			String split_extension = fileName.substring(fileName.lastIndexOf(".")+1);
			
			
//			System.out.println(split_fileName);
//			System.out.println(split_extension);
			
			//Ï§ëÎ≥µ?êú ?åå?ùº?ùÑ ?óÖÎ°úÎìú ?ïòÏß? ?ïäÍ∏? ?úÑ?ï¥ UIDÍ∞? ?Éù?Ñ±
			UUID uid = UUID.randomUUID();
			
			String saveFileName = split_fileName + "_"+ uid + "."+ split_extension;
			
//			System.out.println(fileUploadPath);
//			System.out.println("?óÖÎ°úÎìú ?åå?ùº ?ù¥Î¶? : "+ fileName); //?ö¥?òÅÏ≤¥Ï†ú?óê ?î∞Î•? ?åå?ùº Í≤ΩÎ°úÎΩëÍ∏∞ File.separator
//			System.out.println(saveFileName); //???û•?ï† ?åå?ùº ?ù¥Î¶?
			//?óÖÎ°úÎìú ?åå?ùº ???û•
			File file = new File(fileUploadPath + saveFileName);
			item.write(file);
			
			attachfile = new Att();
			
			attachfile.setAttName(fileName);
			attachfile.setAttPath(fileUploadPath);
			attachfile.savefilename(saveFileName);
			attachfile.setAttSize(String.valueOf(fileSize));
			attachfile.setAttType(item.getContentType());
			
			String fileType = item.getContentType();
			String type = fileType.substring(0,fileType.indexOf("/"));
		
			if(type.equals("image")) {
				attachfile.setAttThumb(setThumbnail(saveFileName,file));
				
			}
		}
		return attachfile;
	}

	@Override
	public Thumbnail setThumbnail(String saveFileName, File file) throws IOException {
		
	//?Ñ¨?Ñ§?ùº ?åå?ùº ???û•
		String thumbFileName = "thumb_200x200_" + saveFileName;
		String thumbFilePath = "D:/jmh/upload/thumbnail/";
		File thumbFile = new File(thumbFilePath+thumbFileName);
		
		Thumbnails.of(file).size(338, 338).toFile(thumbFile);
		
		Thumbnail thumbnail = new Thumbnail();
		thumbnail.setFileName(thumbFileName);
		thumbnail.setFilePath(thumbFilePath);
		//?åå?ùº ?Ç¨?ù¥Ï¶? Íµ¨ÌïòÍ∏?
		thumbnail.setFileSize(String.valueOf(thumbFile.length()));
		
		return thumbnail;
				
	}
	
	@Override
	public Pro getFormParameter(FileItem item,Pro pro,Item proitem) throws ParseException {
		DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		//<input> : ?ÉúÍ∑∏Í∞í
		//System.out.printf("?ïÑ?ìú?ù¥Î¶? : %s, ?ïÑ?ìúÍ∞?: %s\n", item.getFieldName(), item.getString());
		String get = item.getString();
		if (item.getFieldName().equals("proStat")) {
			pro.setProStat(get);
			
		}else if (item.getFieldName().equals("proPrice")) {
			pro.setProPrice(Integer.parseInt(get));
			
		}else if (item.getFieldName().equals("proHits")) {
			pro.setProHits(Integer.parseInt(get));
			
		}else if (item.getFieldName().equals("proSaleprice")) {
			pro.setProSaleprice(Integer.parseInt(get));
		}else if (item.getFieldName().equals("proOpendate")) {
			pro.setProOpendate(get);
			
		}else if (item.getFieldName().equals("itemseqno")) {
			proitem.setItemSeqno(Integer.parseInt(get));
			
		}else if (item.getFieldName().equals("seqno")) {
			pro.setProSeqno(Integer.parseInt(get));
			
		}else if (item.getFieldName().equals("proClosedate")) {
			pro.setProClosedate(get);
		}else if (item.getFieldName().equals("proDetail")) {
			pro.setProDetail(get);
		}else if (item.getFieldName().equals("amount")) {
			pro.setProAmount(Integer.parseInt(get));
		}else if (item.getFieldName().equals("itemDetail")) {
			proitem.setItemDetail(get);
		}else if (item.getFieldName().equals("itemName")) {
			proitem.setItemName(get);
			
		}
		pro.setItem(proitem);
		return pro;
		
	}

	@Override
	public Auc getFormParameter2(FileItem item, Auc auc, Item proitem) throws ParseException {
		//<input> : ?ÉúÍ∑∏Í∞í
		//System.out.printf("?ïÑ?ìú?ù¥Î¶? : %s, ?ïÑ?ìúÍ∞?: %s\n", item.getFieldName(), item.getString());
		
		String get = item.getString();
		
		if (item.getFieldName().equals("auc_stat")) {
			auc.setAucStat(get);
		}else if (item.getFieldName().equals("auc_price")) {
			auc.setAucPrice(Integer.parseInt(get));
		}else if (item.getFieldName().equals("auc_shortdetail")) {
			auc.setAucShortdetail(get);
		}else if (item.getFieldName().equals("auc_start")) {
			auc.setAucStart(get);
		}else if (item.getFieldName().equals("auc_finish")) {
			auc.setAucFinish(get);
		}else if (item.getFieldName().equals("auc_detail")) {
			auc.setAucDetail(get);
		}else if (item.getFieldName().equals("itemDetail")) {
			proitem.setItemDetail(get);
		}else if (item.getFieldName().equals("item_name")) {
			proitem.setItemName(get);
		}else if (item.getFieldName().equals("itemseqno")) {
			proitem.setItemSeqno(Integer.parseInt(get));
		}else if (item.getFieldName().equals("seqno")) {
			auc.setAucSeqno(Integer.parseInt(get));
		}
		auc.setItem(proitem);
		return auc;
		
	}

	public Mem getFormParameter_mypage(FileItem item, Mem mem, Address add) {
		//System.out.printf("?ïÑ?ìú?ù¥Î¶? : %s, ?ïÑ?ìúÍ∞?: %s\n", item.getFieldName(), item.getString());

		String get = item.getString();
		if (item.getFieldName().equals("phone")) {
			mem.setMemTel(get);
		}else if (item.getFieldName().equals("email")) {
			mem.setMemEmail(get);
		}else if (item.getFieldName().equals("sns")) {
			mem.setMemSnsinfo(get);
		}else if (item.getFieldName().equals("cate")) {
			add.setAddCategory(get);
		}else if (item.getFieldName().equals("mobile")) {
			add.setAddPhone(get);
		}else if (item.getFieldName().equals("person")) {
			add.setAddPerson(get);
		}else if (item.getFieldName().equals("address")) {
			add.setAddAddress(get);
		}else if (item.getFieldName().equals("address_detail")) {
			add.setAddetail(get);
		}
		mem.setAddressSet(add);
		
		return mem;
	}
	
	
	@Override
	public int delete(String no, String savefilename, String filepath, String thumb_filename) {
		FileDao filedao = new FileDao();
		
		int rs = 0;
		if(no != null) {
		rs = filedao.deletfile(no);
		}
		//attachfile ?†àÏΩîÎìú ?Ç≠?†ú
		//?åå?ùº?Ç≠?†ú
		File file = new File(filepath+savefilename);
		if (file.exists()) {
			file.delete();
			//?ç∏?Ñ§?ùº ?Ç≠?†ú
			if(thumb_filename != null) {
				File thumbfile = new File(filepath+"thumbnail/"+thumb_filename);
				if(thumbfile.exists()) {
					thumbfile.delete();
				}
			}
			rs=1;
		}
		return rs;
	}

	public Marketing getFormParameter_marketing(FileItem item, Marketing market, Address add) {
		//System.out.printf("?ïÑ?ìú?ù¥Î¶? : %s, ?ïÑ?ìúÍ∞?: %s\n", item.getFieldName(), item.getString());

		String get = item.getString();
		if (item.getFieldName().equals("marcate")) {
			market.setMarCategory(get);;
		}else if (item.getFieldName().equals("name")) {
			market.setMarProduct(get);
		}else if (item.getFieldName().equals("price")) {
			market.setMarPrice(get);
		}else if (item.getFieldName().equals("company")) {
			market.setMarCompany(get);
		}else if (item.getFieldName().equals("ceo")) {
			market.setMarCeo(get);
		}else if (item.getFieldName().equals("phone")) {
			market.setMarPhone(get);
		}else if (item.getFieldName().equals("regnum")) {
			market.setMarRegnum(get);
		}else if (item.getFieldName().equals("start")) {
			market.setMarOpendate(get);
		}else if (item.getFieldName().equals("finish")) {
			market.setMarClosedate(get);
		}else if (item.getFieldName().equals("comment")) {
			market.setMarDetail(get);
		}else if (item.getFieldName().equals("seqno")) {
			market.setMarSeqno(Integer.parseInt(get));
		}
		return market;
	}
}
