package com.cre8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cre8.common.OracleConn;
import com.cre8.dto.Cat;
import com.cre8.dto.Creator;
import com.cre8.dto.Item;
import com.cre8.dto.Mem;
import com.cre8.dto.MemAuth;
import com.cre8.dto.Pro;


public class MainDao {

	Connection conn = OracleConn.getInstance().getConn();
	PreparedStatement stmt;

	public List<Pro> mainList() {
		List<Pro> mainlist = new ArrayList<Pro>();
		Pro pro = null;
		Item item = null;
		Cat cat = null;
		
		String sql = "select i.item_img as item_img, i.item_name as item_name,"
				   + " p.pro_price as pro_price, p.pro_hits as pro_hits, i.cat_seqno"
				   + " from item i, pro p "
			       + " where i.item_seqno = p.item_seqno and i.cat_seqno = 6";

		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
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
		}
		return mainlist;
	}
		
	public HashMap<String, List<Creator>> creList() {
		HashMap<String, List<Creator>> creatormap = new HashMap<String, List<Creator>>();
		List<Creator> hotcrelist = new ArrayList<Creator>();
		List<Creator> newcrelist = new ArrayList<Creator>();
		List<Creator> detailcrelist = new ArrayList<Creator>();
		Mem mem = null;
		Creator creator = null;
		
		String sql = "select k.mem_id, k.mem_name, k.mem_tel, k.mem_email, k.mem_snsinfo, count(k.mem_id) as cnt"
				   + " from pro p,"
				   + " (select m.mem_id, mem_name, mem_tel, m.MEM_EMAIL, m.mem_snsinfo,  a.auth_name, a.auth_date"
				   + " from mem m, mem_auth a"
				   + " where m.mem_id = a.mem_id and a.auth_name = 'C') k"
				   + " where p.mem_id = k.mem_id and p.pro_stat = 'END'"
				   + " group by k.mem_id, k.mem_name, k.mem_tel, k.mem_email, k.mem_snsinfo"
				   + " order by cnt desc";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
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
			
			sql = "select m.mem_id, m.mem_name, m.mem_tel, m.MEM_EMAIL, m.mem_snsinfo,  a.auth_name, a.auth_date"
				+ " from mem m, mem_auth a"
				+ " where m.mem_id = a.mem_id "
				+ " and a.auth_name = 'C'"
				+ " order by a.auth_date desc";
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
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
			
			
			sql = "select z.mem_id, z.mem_img, z.cre_name, z.cre_company, z.cre_phone, z.cre_address, z.cre_salenum, (select item_img from item i where p.item_seqno = i.item_seqno) as img"
					+ " from pro p,"
					+ " (select c.cre_name, c.cre_phone, c.cre_company, c.cre_address, c.cre_salenum, m.mem_id"
					+ " from creator c, mem m"
					+ " where c.mem_id = m.mem_id "
					+ " and m.mem_id = 'ddd')z"
					+ " where p.mem_id = z.mem_id";
			

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
		}
		creatormap.put("new", newcrelist);
		creatormap.put("hot", hotcrelist);
		creatormap.put("detail", detailcrelist);
		
		return creatormap;
	}

	public Creator detailcre(String memid) {
		Creator cre = new Creator();
		String sql = "select z.mem_name, z.mem_img ,z.cre_name, z.cre_phone, z.cre_company, z.cre_address, z.cre_salenum, (select item_img from item i where p.item_seqno = i.item_seqno) as img"
				+ " from pro p,"
				+ " (select m.mem_img,m.mem_name, c.cre_name, c.cre_phone, c.cre_company, c.cre_address, c.cre_salenum, m.mem_id"
				+ " from creator c, mem m"
				+ " where c.mem_id = m.mem_id"
				+ " and m.mem_id = ?)z"
				+ " where p.mem_id = z.mem_id";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, memid);
			ResultSet rs = stmt.executeQuery();
			
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
		}
		return cre;
	}
}
