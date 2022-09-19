package com.cre8.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.apache.commons.fileupload.FileItem;

import dto.Att;
import dto.Auc;
import dto.Item;
import dto.Pro;
import dto.Thumbnail;

public interface FileService {

	public Att fileUpload(FileItem item) throws Exception;
	
	public Thumbnail setThumbnail(String saveFileName,File file) throws IOException;

	public Pro getFormParameter(FileItem item, Pro pro, Item proitem) throws ParseException;
	
	public Auc getFormParameter2(FileItem item, Auc pro, Item proitem) throws ParseException;

	int delete(String no, String savefilename, String filepath, String thumb_filename);
}
