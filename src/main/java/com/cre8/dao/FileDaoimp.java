package com.cre8.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cre8.common.OracleConn;
import com.cre8.dto.Att;

@Repository
public class FileDaoimp implements FileDao{
	@Autowired
	DataSource ds;
	
	@Override
	public int deletfile(String no) {
		Connection conn = null;
		int seqno = Integer.parseInt(no);
		int rs = 0;
		//첨�??��?�� ?��코드?��?��, ?��?��?�� ?��코드?��?��
		String sql = "DELETE FROM att_thumb WHERE att_seqno = ?";
		PreparedStatement stmt;
		
		try {
			conn = ds.getConnection();
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
	@Override
	public String insertAttachFile(String seqno,Att attachfile) {
		Connection conn = null;
		//첨�??��?��???��
		String sql = "insert into att(att_seqno, item_seqno, att_name, att_savename, att_size, att_type, att_path)";
		sql += " values(att_seqno.nextval, ?,?,?,?,?,?)";
		PreparedStatement stmt;
		String att_seqno = null;
		try {
			conn = ds.getConnection();
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
	
	@Override
	public void insertThumbNail(Att attachfile,String att_seqno) {
		Connection conn = null;
		String sql = "insert into att_thumb(thumb_seqno, thumb_filename, thumb_filesize, thumb_filepath, att_seqno)"
				+ " values (thumb_seqno.nextval,?,?,?,?)";
		PreparedStatement stmt;
			try {
				conn = ds.getConnection();
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
