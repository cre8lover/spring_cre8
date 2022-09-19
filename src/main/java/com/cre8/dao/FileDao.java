package com.cre8.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cre8.common.OracleConn;
import com.cre8.dto.Att;


public class FileDao {
	private final Connection conn = OracleConn.getInstance().getConn();
	
	public int deletfile(String no) {
		
		int seqno = Integer.parseInt(no);
		int rs = 0;
		//Ï≤®Î??åå?ùº ?†àÏΩîÎìú?Ç≠?†ú, ?Ñ¨?Ñ§?ùº ?†àÏΩîÎìú?Ç≠?†ú
		String sql = "DELETE FROM att_thumb WHERE att_seqno = ?";
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, seqno);
			stmt.executeUpdate();
			
			sql = "DELETE FROM att WHERE att_seqno = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, seqno);
			rs = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public String insertAttachFile(String seqno,Att attachfile) {
		
		//Ï≤®Î??åå?ùº???û•
		String sql = "insert into att(att_seqno, item_seqno, att_name, att_savename, att_size, att_type, att_path)";
		sql += " values(att_seqno.nextval, ?,?,?,?,?,?)";
		PreparedStatement stmt;
		String att_seqno = null;
		try {
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, seqno);
		stmt.setString(2, attachfile.getAttName());
		stmt.setString(3, attachfile.getSavefilename());
		stmt.setString(4, attachfile.getAttSize());
		stmt.setString(5, attachfile.getAttType());
		stmt.setString(6, attachfile.getAttPath());
		stmt.executeQuery();
		
		
		sql = "select max(att_seqno) from att";
		stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		att_seqno = rs.getString(1);
		
		stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return att_seqno;
	}
	
	
	void insertThumbNail(Att attachfile,String att_seqno) {
		
		String sql = "insert into att_thumb(thumb_seqno, thumb_filename, thumb_filesize, thumb_filepath, att_seqno)"
				+ " values (thumb_seqno.nextval,?,?,?,?)";
		PreparedStatement stmt;
			try {
				
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, attachfile.getAttThumb().getFileName());
				stmt.setString(2, attachfile.getAttThumb().getFileSize());
				stmt.setString(3, attachfile.getAttThumb().getFilePath());
				stmt.setString(4, att_seqno);
				stmt.executeQuery();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
