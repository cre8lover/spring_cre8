package com.cre8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cre8.common.OracleConn;


public class ProductDao {

	Connection conn = OracleConn.getInstance().getConn();
	PreparedStatement stmt;

	
	//?ùòÎ•? cat=1
	public List<Pro> proList_clothes() {
		List<Pro> prolist1 = new ArrayList<Pro>(); 
		Pro pro = null;
		Item item = null;
		Cat cat = null;
	
	String sql = "select *"
			+ " from ("
			+ "    select i.item_img as item_img, i.item_name as item_name, p.pro_price as pro_price, p.pro_hits as pro_hits, p.cat_seqno, p.pro_seqno as pro_seqno"
			+ "    from item i, pro p "
			+ "    where i.item_seqno = p.item_seqno and p.cat_seqno = 1) "
			+ "    order by pro_hits desc" ;
	
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
			pro.setProSeqno(rs.getInt("pro_seqno"));
			pro.setItem(item);
			pro.setCat(cat);
			prolist1.add(pro);
		}
		
		stmt.close();	

	} catch (SQLException e) {
		e.printStackTrace();
	}
		return prolist1;
	}
	
	//Í∞??†Ñ&Í∞?Íµ? cat=2
	public List<Pro> proList_furn() {
		List<Pro> prolist2 = new ArrayList<Pro>(); 
		Pro pro = null;
		Item item = null;
		Cat cat = null;
		
		String sql = "select *"
				+ " from ("
				+ "    select i.item_img as item_img, i.item_name as item_name, p.pro_price as pro_price, p.pro_hits as pro_hits, p.cat_seqno, p.pro_seqno as pro_seqno"
				+ "    from item i, pro p "
				+ "    where i.item_seqno = p.item_seqno and p.cat_seqno = 2) "
				+ "    order by pro_hits desc" ;
		
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
				pro.setProSeqno(rs.getInt("pro_seqno"));
				pro.setItem(item);
				pro.setCat(cat);
				prolist2.add(pro);
			}
			
			stmt.close();	

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prolist2;
	}
	
	//?ôî?û•?íà cat=3
	public List<Pro> proList_cos() {
		List<Pro> prolist3 = new ArrayList<Pro>(); 
		Pro pro = null;
		Item item = null;
		Cat cat = null;
		
		String sql = "select *"
				+ " from ("
				+ "    select i.item_img as item_img, i.item_name as item_name, p.pro_price as pro_price, p.pro_hits as pro_hits, p.cat_seqno, p.pro_seqno as pro_seqno"
				+ "    from item i, pro p "
				+ "    where i.item_seqno = p.item_seqno and p.cat_seqno = 3) "
				+ "    order by pro_hits desc" ;
		
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
				pro.setProSeqno(rs.getInt("pro_seqno"));
				pro.setItem(item);
				pro.setCat(cat);
				prolist3.add(pro);
			}
			
			stmt.close();	

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prolist3;
	}
	
	//?ù∏?ÖåÎ¶¨Ïñ¥ cat=4
	public List<Pro> proList_interior() {
		List<Pro> prolist4 = new ArrayList<Pro>(); 
		Pro pro = null;
		Item item = null;
		Cat cat = null;
		
		String sql = "select *"
				+ " from ("
				+ "    select i.item_img as item_img, i.item_name as item_name, p.pro_price as pro_price, p.pro_hits as pro_hits, p.cat_seqno, p.pro_seqno as pro_seqno"
				+ "    from item i, pro p "
				+ "    where i.item_seqno = p.item_seqno and p.cat_seqno = 4) "
				+ "    order by pro_hits desc" ;
		
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
				pro.setProSeqno(rs.getInt("pro_seqno"));
				pro.setItem(item);
				pro.setCat(cat);
				prolist4.add(pro);
			}
			
			stmt.close();	

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prolist4;
	}
	
	//?ó¨?ñâ cat=5
	public List<Pro> proList_tra() {
		List<Pro> prolist5 = new ArrayList<Pro>(); 
		Pro pro = null;
		Item item = null;
		Cat cat = null;
		
		String sql = "select *"
				+ " from ("
				+ "    select i.item_img as item_img, i.item_name as item_name, p.pro_price as pro_price, p.pro_hits as pro_hits, p.cat_seqno, p.pro_seqno as pro_seqno"
				+ "    from item i, pro p "
				+ "    where i.item_seqno = p.item_seqno and p.cat_seqno = 5) "
				+ "    order by pro_hits desc" ;
		
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
				pro.setProSeqno(rs.getInt("pro_seqno"));
				pro.setItem(item);
				pro.setCat(cat);
				prolist5.add(pro);
			}
			
			stmt.close();	

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prolist5;
	}
	
	
	public Pro detailList(String seqno) {
		Pro pro = new Pro();
		String sql = " select (SELECT c.cre_company FROM creator c where c.mem_id = p.mem_id) as companyname,"
				+ "        i.item_img, i.item_name, p.pro_price, p.pro_detail, p.pro_saleprice,"
				+ "        (p.pro_price - P.pro_saleprice) discount ,"
				+ "        (select count(*) from review r where p.pro_seqno = r.pro_seqno) as reviewcount "
				+ " from pro p, item i"
				+ " where p.item_seqno = i.item_seqno and p.item_seqno = ?" ;
				
				
				    
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, seqno);
			ResultSet rs =stmt.executeQuery();
			
			if(rs.next()){
				Item item = new Item();
				item.setItemImg(rs.getString("item_img"));
				item.setItemName(rs.getString("item_name"));
				pro.setCompanyname(rs.getString("companyname"));
				pro.setProPrice(rs.getInt("pro_price"));
				pro.setProSaleprice(rs.getInt("pro_saleprice"));
				pro.setProDetail(rs.getString("pro_detail"));
				pro.setDiscount(rs.getInt("discount"));
				pro.setReviewcount(rs.getInt("reviewcount"));
				pro.setItem(item);
			}
		
			
			sql = " select r.*"
				+ " from review r, pro p"
				+ " where p.pro_seqno = r.pro_seqno and p.pro_seqno = ?" ;
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, seqno);
			rs =stmt.executeQuery();
		
			
			List<Review> review_arr = new ArrayList<Review>();
			while(rs.next()) {
				Review review = new Review();
				review.setReviewSeqno(rs.getInt("review_seqno"));
				review.setReviewContent(rs.getString("review_content"));
				
				Mem m = new Mem();
				m.setMemId(rs.getString("mem_id"));
				
				review.setMem(m);
				review_arr.add(review); 
			}
			pro.setReviewSet(review_arr);
			
			sql = " select *"
					+ " from qna q, pro p"
					+ " where q.pro_seqno = p.pro_seqno and p.pro_seqno = ? ";
			
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, seqno);
			rs =stmt.executeQuery();
			
			List<Qna> qna_arr = new ArrayList<Qna>();
			//List<Reply> reply_arr = new ArrayList<Reply>();
			
			while(rs.next()) {
				Qna qna = new Qna();
				qna.setQnaSeqno(rs.getInt("qna_seqno"));
				qna.setQnaContent(rs.getString("qna_content"));
				qna.setQnaDate(rs.getDate("qna_date"));
				qna.setMemid(rs.getString("mem_id"));
				qna_arr.add(qna);
			}
			pro.setQnaSet(qna_arr);
				
			

			
			
			
		//	qna.setReplySet(reply_arr);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pro;
	}
}

