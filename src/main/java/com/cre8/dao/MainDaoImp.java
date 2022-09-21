package com.cre8.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cre8.common.OracleConn;
import com.cre8.dto.Cat;
import com.cre8.dto.Creator;
import com.cre8.dto.Item;
import com.cre8.dto.Mem;
import com.cre8.dto.MemAuth;
import com.cre8.dto.Pro;

import oracle.jdbc.OracleTypes;

@Repository
public class MainDaoImp implements MainDao{

	

	@Autowired
	private DataSource ds;
	
	@Override
	public List<Pro> mainList() {
		
		Connection conn = null;
		CallableStatement stmt = null;
		
		List<Pro> mainlist = new ArrayList<Pro>();
		Pro pro = null;
		Item item = null;
		Cat cat = null;
		
		String sql = "call p_mainlist(?)";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareCall(sql);
			stmt.registerOutParameter(1, OracleTypes.CURSOR);
			stmt.executeQuery();
			
			ResultSet rs = (ResultSet)stmt.getObject(1);
			
			while (rs.next()) {
				pro = new Pro();
				item = new Item();
				cat = new Cat();
				item.setItemImg(rs.getString("item_img"));
				item.setItemName(rs.getString("item_name"));
				pro.setProPrice(rs.getInt("pro_price"));
				pro.setProHits(rs.getInt("pro_hits"));
				cat.setCatSeqno(rs.getInt("cat_seqno"));
				pro.setItem(item);
				pro.setCat(cat);
				mainlist.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		return mainlist;
	}
		
	@Override
	public HashMap<String, List<Creator>> creList() {
		
		Connection conn = null;
		CallableStatement stmt = null;
		
		HashMap<String, List<Creator>> creatormap = new HashMap<String, List<Creator>>();
		List<Creator> hotcrelist = new ArrayList<Creator>();
		List<Creator> newcrelist = new ArrayList<Creator>();
		List<Creator> detailcrelist = new ArrayList<Creator>();
		Mem mem = null;
		Creator creator = null;
		
		String sql = "call p_hotcrelist(?)";
		try {
			conn = ds.getConnection();
			stmt = conn.prepareCall(sql);
			stmt.registerOutParameter(1, OracleTypes.CURSOR);
			stmt.executeQuery();
			ResultSet rs = (ResultSet)stmt.getObject(1);
			
			while (rs.next()) {
				mem = new Mem();
				creator = new Creator();
				mem.setMemId(rs.getString("mem_id"));
				mem.setMemName(rs.getString("mem_name"));
				mem.setMemTel(rs.getString("mem_tel"));
				mem.setMemEmail(rs.getString("mem_email"));
				mem.setMemSnsinfo(rs.getString("mem_snsinfo"));
				creator.setMem(mem);
				hotcrelist.add(creator);
			}
			
			sql = "call p_newcrelist(?)";
			stmt = conn.prepareCall(sql);
			stmt.registerOutParameter(1, OracleTypes.CURSOR);
			stmt.executeQuery();
			rs = (ResultSet)stmt.getObject(1);
			while (rs.next()) {
				mem = new Mem();
				creator = new Creator();
				mem.setMemId(rs.getString("mem_id"));
				mem.setMemName(rs.getString("mem_name"));
				mem.setMemTel(rs.getString("mem_tel"));
				mem.setMemEmail(rs.getString("mem_email"));
				mem.setMemSnsinfo(rs.getString("mem_snsinfo"));
				
				MemAuth a = new MemAuth();
				a.setAuthName(rs.getString("auth_name"));
				a.setAuthName(rs.getString("auth_date"));
				
				mem.setMemAuthSet(a);
				
				creator.setMem(mem);
				newcrelist.add(creator);
			}
			
			
			sql = "call p_solcrelist(?)";
			stmt = conn.prepareCall(sql);
			stmt.registerOutParameter(1, OracleTypes.CURSOR);
			stmt.executeQuery();
			rs = (ResultSet)stmt.getObject(1);

			while (rs.next()) {
				creator = new Creator();
				Item item = new Item();
				mem.setMemId(rs.getString("mem_id"));
				mem.setMemImg(rs.getString("mem_Img"));
				creator.setCreName(rs.getString("cre_name"));
				creator.setCreCompany(rs.getString("cre_company"));
				creator.setCreAddress(rs.getString("cre_address"));
				creator.setCreSalenum(rs.getString("cre_salenum"));
				creator.setCrePhone(rs.getString("cre_phone"));
				creator.setCreSalenum(rs.getString("cre_salenum"));
				item.setItemImg(rs.getString("img"));
//				item.setItemSeqno(rs.getInt("item_seqno"));
				
				mem.setItemSet(item);
				creator.setMem(mem);
				detailcrelist.add(creator);
			}
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		creatormap.put("new", newcrelist);
		creatormap.put("hot", hotcrelist);
		creatormap.put("detail", detailcrelist);
		
		return creatormap;
	}

	@Override
	public Creator detailcre(String memid) {
		
		Connection conn = null;
		CallableStatement stmt = null;
		
		Creator cre = new Creator();
		String sql = "call p_detailcre(?,?)";
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareCall(sql);
			stmt.setString(1, memid);
			stmt.registerOutParameter(2, OracleTypes.CURSOR);
			stmt.executeQuery();
			ResultSet rs = (ResultSet)stmt.getObject(2);
			
			if(rs.next()) {
				//Item item = new Item();
				Mem mem = new Mem();
				mem.setMemImg(rs.getString("mem_img"));
				mem.setMemName(rs.getString("mem_name"));
				cre.setCreName(rs.getString("cre_name"));
				cre.setCreCompany(rs.getString("cre_company"));
				cre.setCreAddress(rs.getString("cre_address"));
				cre.setCreSalenum(rs.getString("cre_salenum"));
				cre.setCrePhone(rs.getString("cre_phone"));
				//item.setItemImg(rs.getString("img"));
				
				cre.setMem(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		return cre;
	}
	
	private void resourceClose(Connection conn, CallableStatement stmt) {
		//�옄�썝諛섎궔
		try {
			if(stmt != null || conn != null) {
				stmt.close();
				conn.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
