package com.cre8.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cre8.common.OracleConn;
import com.cre8.dto.Auc;
import com.cre8.dto.AucNowing;
import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.Item;
import com.cre8.dto.Mem;

import oracle.jdbc.OracleTypes;
@Repository
public class AucDao {
   @Autowired
   DataSource ds;

   
//   public Map<String, List<Auc>> aucList(Auc_Criteria cri) {
//	   
//	  
//	   
//      Map<String, List<Auc>> aucmap = new HashMap<String, List<Auc>>();
//      List<Auc> auclist = new ArrayList<Auc>(); 
//      List<Auc> hitlist = new ArrayList<Auc>(); 
//      List<Auc> lastlist = new ArrayList<Auc>(); 
//      Auc auc = null;
//      Item item = null;
//      
//      String sql = "select *  from ( select i.item_seqno as item_seqno, i.item_img as item_img, i.item_name as item_name, a.auc_detail as auc_detail, a.auc_price as auc_price, "
//            + " a.auc_closeprice as auc_closeprice, a.auc_seqno as auc_seqno,    a.auc_hits as auc_hits, a.auc_start as sdate, to_char(a.auc_finish, 'YYYY-MM-DD,HH24:MI:SS') as fdate, "
//            + " (to_date(a.auc_finish, 'YYYY-MM-DD,HH24:MI:SS')-to_date(a.auc_start, 'YYYY-MM-DD,HH24:MI:SS')) as minusday "
//            + " from item i, auc a where i.item_seqno = a.item_seqno) order by sdate desc";
//      
//      try {
//         stmt = conn.prepareStatement(sql);
//         ResultSet rs = stmt.executeQuery();
//         while (rs.next()) {
//            auc = new Auc();
//            item = new Item();
//            String itemseqno = rs.getString("item_seqno");
//            auc.setAucImg(rs.getString("item_img"));
//            item.setItemName(rs.getString("item_name"));
//            item.setItemDetail(rs.getString("auc_detail"));
//            auc.setAucPrice(rs.getInt("auc_price"));
//            auc.setAucCloseprice(rs.getInt("auc_closeprice"));
//            auc.setAucStart(rs.getString("sdate"));
//            auc.setAucFinish(rs.getString("fdate"));
//            auc.setAucSeqno(rs.getInt("auc_seqno"));
//            auc.setAucAmount(rs.getInt("minusday"));
//            
//            
//			sql = " select THUMB_FILENAME, THUMB_FILEPATH "
//					+ " from att_thumb"
//					+ " where att_seqno = (select att_seqno from att where item_seqno = ?)";
//			
//			stmt = conn.prepareStatement(sql);
//			stmt.setString(1, itemseqno);
//			ResultSet rs2 = stmt.executeQuery();
//			if(rs2.next()) {
//				item.setItemImg(rs2.getString("thumb_filename"));
//			}
//            auc.setItem(item);
//            auclist.add(auc);
//         }
//         
//         sql = "select *  from (select i.item_seqno as item_seqno, i.item_img as item_img, i.item_name as item_name, a.auc_detail as auc_detail, a.auc_price as auc_price, "
//            + " a.auc_closeprice as auc_closeprice, a.auc_seqno as auc_seqno,    a.auc_hits as auc_hits, a.auc_start as sdate, to_char(a.auc_finish, 'YYYY-MM-DD,HH24:MI:SS') as fdate, "
//            + " (to_date(a.auc_finish, 'YYYY-MM-DD,HH24:MI:SS')-to_date(a.auc_start, 'YYYY-MM-DD,HH24:MI:SS')) as minusday "
//            + " from item i, auc a where i.item_seqno = a.item_seqno) order by auc_hits desc";
//         
//         
//         stmt = conn.prepareStatement(sql);
//         rs = stmt.executeQuery();
//         while (rs.next()) {
//            auc = new Auc();
//            item = new Item();
//            String itemseqno = rs.getString("item_seqno");
//            auc.setAucImg(rs.getString("item_img"));
//            item.setItemName(rs.getString("item_name"));
//            item.setItemDetail(rs.getString("auc_detail"));
//            auc.setAucPrice(rs.getInt("auc_price"));
//            auc.setAucCloseprice(rs.getInt("auc_closeprice"));
//            auc.setAucStart(rs.getString("sdate"));
//            auc.setAucFinish(rs.getString("fdate"));
//            auc.setAucSeqno(rs.getInt("auc_seqno"));
//            auc.setAucAmount(rs.getInt("minusday"));
//
//            
//			sql = " select THUMB_FILENAME, THUMB_FILEPATH "
//					+ " from att_thumb"
//					+ " where att_seqno = (select att_seqno from att where item_seqno = ?)";
//			
//			stmt = conn.prepareStatement(sql);
//			stmt.setString(1, itemseqno);
//			ResultSet rs2 = stmt.executeQuery();
//			if(rs2.next()) {
//				item.setItemImg(rs2.getString("thumb_filename"));
//			}
//            auc.setItem(item);
//            hitlist.add(auc);
//         }
//         
//         
//         sql = "select *  from (select i.item_seqno as item_seqno, i.item_img as item_img, i.item_name as item_name, a.auc_detail as auc_detail, a.auc_price as auc_price, "
//               + " a.auc_closeprice as auc_closeprice, a.auc_seqno as auc_seqno,    a.auc_hits as auc_hits, a.auc_start as sdate, to_char(a.auc_finish, 'YYYY-MM-DD,HH24:MI:SS') as fdate, "
//               + " (to_date(a.auc_finish, 'YYYY-MM-DD,HH24:MI:SS')-to_date(a.auc_start, 'YYYY-MM-DD,HH24:MI:SS')) as minusday "
//               + " from item i, auc a where i.item_seqno = a.item_seqno) order by minusday";
//            
//            
//            stmt = conn.prepareStatement(sql);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//               auc = new Auc();
//               item = new Item();
//               String itemseqno = rs.getString("item_seqno");
//               auc.setAucImg(rs.getString("item_img"));
//               item.setItemName(rs.getString("item_name"));
//               item.setItemDetail(rs.getString("auc_detail"));
//               auc.setAucPrice(rs.getInt("auc_price"));
//               auc.setAucCloseprice(rs.getInt("auc_closeprice"));
//               auc.setAucStart(rs.getString("sdate"));
//               auc.setAucFinish(rs.getString("fdate"));
//               auc.setAucSeqno(rs.getInt("auc_seqno"));
//               auc.setAucAmount(rs.getInt("minusday"));
//               sql = " select THUMB_FILENAME, THUMB_FILEPATH "
//					+ " from att_thumb"
//					+ " where att_seqno = (select att_seqno from att where item_seqno = ?)";
//			
//			stmt = conn.prepareStatement(sql);
//			stmt.setString(1, itemseqno);
//			ResultSet rs2 = stmt.executeQuery();
//			if(rs2.next()) {
//				item.setItemImg(rs2.getString("thumb_filename"));
//			}
//               auc.setItem(item);
//               lastlist.add(auc);
//            }
//         
//         stmt.close();   
//   
//      } catch (SQLException e) {
//         e.printStackTrace();
//      }
//      
//      aucmap.put("last", lastlist);
//      aucmap.put("hit", hitlist);
//      aucmap.put("auc", auclist);
//      
//      return aucmap;
//   }
   
   public List<Auc> aucList(Auc_Criteria cri) {
	   Connection conn = null;
	   CallableStatement cstmt = null;
		  
	      List<Auc> auclist = new ArrayList<Auc>(); 
	      Auc auc = null;
	      Item item = null;
	      
	      String sql = "call aucList(?,?,?,?,?)";
	      
	      try {
	    	  conn = ds.getConnection();
	         cstmt = conn.prepareCall(sql);
	         
	         cstmt.setString(1, cri.getCategory());
	         cstmt.setInt(2, cri.getCurrentPage());
	         cstmt.setInt(3, cri.getRowPerPage());
	         cstmt.registerOutParameter(4, OracleTypes.CURSOR);
	         cstmt.registerOutParameter(5, OracleTypes.INTEGER);
	         cstmt.executeQuery();
	         
	         ResultSet rs = (ResultSet)cstmt.getObject(4);
	         
	         
	         while (rs.next()) {
	            auc = new Auc();
	            item = new Item();
//	            String itemseqno = rs.getString("item_seqno");
	            auc.setAucImg(rs.getString("item_img"));
	            item.setItemName(rs.getString("item_name"));
	            
	            item.setItemDetail(rs.getString("auc_detail"));
	            item.setItemAmount(cstmt.getInt(5));
	            auc.setAucPrice(rs.getInt("auc_price"));
	            auc.setAucCloseprice(rs.getInt("auc_closeprice"));
	            auc.setAucStart(rs.getString("sdate"));
	            auc.setAucFinish(rs.getString("fdate"));
	            auc.setAucSeqno(rs.getInt("auc_seqno"));
	            auc.setAucAmount(rs.getInt("minusday"));
				item.setItemImg(rs.getString("item_img"));
	            auc.setItem(item);
	            auclist.add(auc);
	         }
	         
	         
	         cstmt.close();   
	   
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      return auclist;
	   }
   
   
   
   
   
   
//
//
//   ?��?��?��?��?���?
   public Auc detailList(String seqno) {
	   Connection conn = null;
	   CallableStatement cstmt = null;
      Auc auc = null;
      Item item = null;
      List<AucNowing> anlist = new ArrayList<AucNowing>();
      AucNowing an = null;
      Mem name = null;
      String sql = "call p_auc_detail(?,?,?)";
      	
      try {
    	  conn = ds.getConnection();
         cstmt = conn.prepareCall(sql);
         cstmt.setString(1, seqno);
         cstmt.registerOutParameter(2, OracleTypes.CURSOR);
         cstmt.registerOutParameter(3, OracleTypes.CURSOR);
         cstmt.executeQuery();
         ResultSet rs = (ResultSet)cstmt.getObject(2);
         ResultSet rs2 = (ResultSet)cstmt.getObject(3);
         while (rs.next()) {
            auc = new Auc();
            item = new Item();
            
            item.setItemName(rs.getString("item_name"));
            item.setItemSeqno(rs.getInt("item_seqno"));
            item.setItemDetail(rs.getString("item_detail"));
            auc.setAucSeqno(rs.getInt("auc_seqno"));
            auc.setAucImg(rs.getString("auc_img"));
            auc.setAucShortdetail(rs.getString("auc_shortdetail"));
            auc.setAucPrice(rs.getInt("auc_price"));
            auc.setAucFinish(rs.getString("auc_finish"));
            auc.setAucCloseprice(rs.getInt("aucCloseprice"));
            auc.setAucHits(rs.getInt("auc_count"));
            auc.setAucDetail(rs.getString("mem_id"));
            item.setItemImg(rs.getString("item_img"));
            auc.setItem(item);
         }
         

         while (rs2.next()) {
            an = new AucNowing();
            name = new Mem();

            name.setMemName(rs2.getString("mem_name"));
            name.setMemId(rs2.getString("mem_id"));
            an.setAucnowLastprice(rs2.getInt("aucnow_lastprice"));
            an.setAucnowDate(rs2.getDate("aucnow_date"));
            an.setMem(name);
            anlist.add(an);
         }
         auc.setAucNowingSet(anlist);
         
         cstmt.close();   

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return auc;
   }
   	
   
   	
   
   
   
   
   
   
   
//   public Auc detailList(String seqno) {
//	      Auc auc = null;
//	      Item item = null;
//	      List<AucNowing> anlist = new ArrayList<AucNowing>();
//	      AucNowing an = null;
//	      Mem name = null;
//	      String sql = "select i.item_seqno as item_seqno, i.item_name as item_name, i.item_img as item_img, "
//	            + " y.auc_seqno as auc_seqno, y.auc_img as auc_img, y.auc_shortdetail as auc_shortdetail, "
//	            + " y.auc_price as auc_price, to_char(y.auc_finish, 'YYYY-MM-DD,HH24:MI:SS') as auc_finish, y.aucCloseprice as aucCloseprice, "
//	            + " y.auc_count as auc_count, i.mem_id as mem_id, i.item_detail as item_detail"
//	            + " from item i,"
//	            + "    (select a.item_seqno, a.auc_seqno, a.auc_img as auc_img ,"
//	            + "    a.auc_shortdetail, a.auc_price, a.auc_finish, a.auc_start, "
//	            + "    (select max(an.aucnow_lastprice) from auc_nowing an where a.auc_seqno=an.auc_seqno) as aucCloseprice, "
//	            + "    (select count(an.aucnow_seqno) as auc_count from auc_nowing an where a.auc_seqno = an.auc_seqno) as auc_count "
//	            + " from auc a) y"
//	            + " where y.item_seqno = i.item_seqno"
//	            + " and y.auc_seqno = ?";
//	      
//	      try {
//	         stmt = conn.prepareStatement(sql);
//	         stmt.setString(1, seqno);
//	         ResultSet rs = stmt.executeQuery();
//	         
//	         while (rs.next()) {
//	            auc = new Auc();
//	            item = new Item();
//	            
//	            item.setItemName(rs.getString("item_name"));
//	            
//	            item.setItemDetail(rs.getString("item_detail"));
//	            auc.setAucSeqno(rs.getInt("auc_seqno"));
//	            auc.setAucImg(rs.getString("auc_img"));
//	            auc.setAucShortdetail(rs.getString("auc_shortdetail"));
//	            auc.setAucPrice(rs.getInt("auc_price"));
//	            auc.setAucFinish(rs.getString("auc_finish"));
//	            auc.setAucCloseprice(rs.getInt("aucCloseprice"));
//	            auc.setAucHits(rs.getInt("auc_count"));
//	            auc.setAucDetail(rs.getString("mem_id"));
//	            
//	            sql = "select att_savename from att where item_seqno = ?";
//	            
//	            stmt = conn.prepareStatement(sql);
//	            stmt.setString(1, rs.getString("item_seqno"));
//	            ResultSet rs2 = stmt.executeQuery();
//	            
//	            if(rs2.next()) {
//	            	item.setItemImg(rs2.getString("att_savename"));
//	            }
//	            
//	            
//	            auc.setItem(item);
//	         }
//	         
//	         sql = " select m.mem_name as mem_name, an.aucnow_date as aucnow_date, an.aucnow_lastprice as aucnow_lastprice, m.mem_id as mem_id "
//	               + " from auc_nowing an ,  mem m"
//	               + " where m.mem_id = an.mem_id"
//	               + " and an.auc_seqno = ?"
//	               + " order by an.aucnow_lastprice desc";
//	         
//	         stmt = conn.prepareStatement(sql);
//	         stmt.setString(1, seqno);
//	         rs = stmt.executeQuery();
//	         
//	         while (rs.next()) {
//	            an = new AucNowing();
//	            name = new Mem();
//	            
//	            name.setMemName(rs.getString("mem_name"));
//	            name.setMemId(rs.getString("mem_id"));
//	            an.setAucnowLastprice(rs.getInt("aucnow_lastprice"));
//	            an.setAucnowDate(rs.getDate("aucnow_date"));
//	            an.setMem(name);
//	            anlist.add(an);
//	         }
//	         auc.setAucNowingSet(anlist);
//	         
//	         stmt.close();   
//
//	      } catch (SQLException e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	      }
//
//	      return auc;
//	   }
   
   
   
   
   

   public void aucnow(String srt, String seqno, String id) {
	   Connection conn = null;
	   PreparedStatement stmt = null;
      
      String sql = "insert into auc_nowing(aucnow_seqno,aucnow_lastprice,auc_seqno,mem_id) values (aucnow_seqno.nextVal,?,?,?)";
      
      try {
         conn = ds.getConnection();
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, srt);
      stmt.setString(2, seqno);
      stmt.setString(3, id);
      stmt.executeQuery();
         
      sql = "update auc set auc_closeprice = ? where auc_seqno = ? ";
         
      stmt =conn.prepareStatement(sql);
         
      stmt.setString(1, srt);
      stmt.setString(2, seqno);
      stmt.executeQuery();
      
      stmt.close();   

      } catch (SQLException e) {
         e.printStackTrace();
      }      
      
      
   }

}