package com.cre8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.Cart;
import com.cre8.dto.Cat;
import com.cre8.dto.Item;
import com.cre8.dto.Mem;
import com.cre8.dto.Pro;
import com.cre8.dto.Qna;
import com.cre8.dto.Review;

@Repository
public class ProductDaoimp implements ProductDao{
	
	@Autowired
	private DataSource ds;
	
	//?占쏙옙占�? cat=1
	public List<Pro> proList_clothes(Auc_Criteria ac) {
		PreparedStatement stmt = null;
		Connection conn = null;
		List<Pro> prolist1 = new ArrayList<Pro>(); 
		Pro pro = null;
		Item item = null;
		Cat cat = null;
	
	String sql = "select *"
			+ " from ("
			+ "    select (select (select thumb_filename from att_thumb at where at.att_seqno = a.att_seqno) from att a where a.item_seqno = i.item_seqno) as item_img, "
			+ "		i.item_name as item_name, p.pro_price as pro_price, p.pro_hits as pro_hits, p.cat_seqno, p.pro_seqno as pro_seqno"
			+ "    from item i, pro p "
			+ "    where i.item_seqno = p.item_seqno and p.cat_seqno = ?) "
			+ "    order by pro_hits desc" ;
	
	try {
		conn = ds.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, ac.getCategory());
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
	

	public Pro detailList(String seqno) {
		PreparedStatement stmt = null;
		Connection conn = null;
		System.out.println("seqno = "+seqno);
		Pro pro = new Pro();
		String sql = " select (SELECT c.cre_company FROM creator c where c.mem_id = p.mem_id) as companyname,"
				+ "        (select att_savename from att where item_seqno = i.item_seqno) as item_img, "
				+ "			i.item_name, p.pro_price, p.pro_detail, p.pro_saleprice,p.pro_amount,p.pro_seqno, "
				+ "        (p.pro_price - P.pro_saleprice) discount ,"
				+ "        (select count(*) from review r where p.pro_seqno = r.pro_seqno) as reviewcount "
				+ " from pro p, item i"
				+ " where p.item_seqno = i.item_seqno and p.pro_seqno = ?" ;
				
				
				    
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, seqno);
			ResultSet rs =stmt.executeQuery();
			
			if(rs.next()){
				Item item = new Item();
				item.setItemImg(rs.getString("item_img"));
				item.setItemName(rs.getString("item_name"));
				pro.setProSeqno(rs.getInt("pro_seqno"));
				pro.setProAmount(rs.getInt("pro_amount"));
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

	public List<Cart> nowbuy(String seqno, String amount) {
		PreparedStatement stmt = null;
		Connection conn = null;
		
		List<Cart> cartlist = new ArrayList<Cart>();
		Cart cart = null;
		Pro pro = null;
		Item item = null;
		try {
			conn = ds.getConnection();
			String sql = "select (select item_name from item i where i.item_seqno = p.item_seqno) item_name, "
					+ "                    (select item_seqno from item i where i.item_seqno = p.item_seqno) item_seqno, "
					+ "                    (select (select (select thumb_filename "
					+ "                                     from att_thumb at where at.att_seqno = a.att_seqno) "
					+ "                            from att a where a.item_seqno = i.item_seqno) "
					+ "                     from item i where i.item_seqno = p.item_seqno ) item_img, "
					+ "                     p.pro_price as pro_price, "
					+ "                     p.pro_seqno as pro_seqno,(p.pro_price * ?) as totalprice "
					+ "              from (select * from pro p "
					+ " where pro_seqno = ?) p ";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, Integer.parseInt(amount));
			stmt.setString(2, seqno);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				
				cart = new Cart();
				pro = new Pro();
				item = new Item();
	
				item.setItemName(rs.getString("item_name"));
				pro.setProPrice(rs.getInt("pro_price"));
				pro.setProSeqno(rs.getInt("pro_seqno"));
				cart.setCartAmount(Integer.parseInt(amount));
				cart.setTotalprice(rs.getInt("totalprice"));
				item.setItemImg(rs.getString("item_img"));
				
				pro.setItem(item);
				cart.setPro(pro);
				cartlist.add(cart);
				
			}
			
			conn.close();
			stmt.close();
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cartlist;
	}
}

