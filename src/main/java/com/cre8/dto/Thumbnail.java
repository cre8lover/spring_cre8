
package com.cre8.dto;

public class Thumbnail {

	private String fileName;
	private String filePath;
	private String fileSize;
	private String thumbSeqNo;
	
	
	
	public String getThumbSeqNo() {
		return thumbSeqNo;
	}

	public void setThumbSeqNo(String thumbSeqNo) {
		this.thumbSeqNo = thumbSeqNo;
	}

	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getFileSize() {
		return fileSize;
	}
	
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
}