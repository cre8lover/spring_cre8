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

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cre8.common.OracleConn;
import com.cre8.dto.Address;
import com.cre8.dto.Att;
import com.cre8.dto.Auc;
import com.cre8.dto.AucNowing;
import com.cre8.dto.Cart;
import com.cre8.dto.Item;
import com.cre8.dto.Mem;
import com.cre8.dto.Orderdetail;
import com.cre8.dto.Orders;
import com.cre8.dto.Pro;
import com.cre8.dto.Ship;
import com.cre8.dto.Thumbnail;
import com.cre8.dto.Waybill;

import oracle.jdbc.internal.OracleTypes;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

@Repository
public class MemberDaoImp implements MemberDao{
//	private final Connection conn = OracleConn.getInstance().getConn();
	
	@Autowired
	private DataSource ds;
	
	public Map<String, String> longinProc(String id, String pw) {

		Map<String, String> map = new HashMap<String, String>();
		
		String sql = "call p_login(?,?)";
		
		CallableStatement cstmt = null;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			cstmt = conn.prepareCall(sql);
		
			cstmt.setString(1, id);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.executeQuery();
			ResultSet rs = (ResultSet)cstmt.getObject(2);
			
			if(rs.next()) {
				
				if(rs.getString("mem_pw").equals(pw)) {
					//濡쒓렇?占쏙옙 ?占쏙옙占�?
					map.put("login", "ok");
					map.put("name",rs.getString("mem_name"));
					map.put("auth",rs.getString("auth_name"));
					
				} else {
					//鍮꾬옙?踰덊샇 ?占쏙옙占�?
					map.put("login", "pwfail");
				}
				
			} else {
				map.put("login", "no_member");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			resourceClose(conn, cstmt);
		}
		
		
		return map;
	}

	public String reginsert(Mem mem) {
	
		CallableStatement cstmt = null;
		Connection conn = null;
		
		String sql = "call p_reginsert(?,?,?,?,?,?,?)";
		
		String in = "?占쏙옙占�?";
		
		try {
			conn = ds.getConnection();
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, mem.getMemId());
			cstmt.setString(2, mem.getMemPw());
			cstmt.setString(3, mem.getMemTel());
			cstmt.setString(4, mem.getMemEmail());
			cstmt.setString(5, mem.getMemBirth());
			cstmt.setString(6, mem.getMemName());
			cstmt.setString(7, mem.getCheck());
			
			cstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, cstmt);
		}
		
		return in;
	}

	public Mem mypage(String id) {
		PreparedStatement stmt = null;
		CallableStatement cstmt = null;
		Connection conn = null;
		
		Mem member = new Mem();
//		Address add = new Address();
		
		String sql = "call p_mypage(?,?)";
		try {
			conn = ds.getConnection();
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, id);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.executeQuery();
			
			ResultSet rs = (ResultSet)cstmt.getObject(2);
			
			Address addr = null;
			
			if(rs.next()) {
				member.setMemId(rs.getString("mem_id"));
				member.setMemEmail(rs.getString("mem_email"));
				member.setMemTel(rs.getString("mem_tel"));
				member.setMemName(rs.getString("mem_name"));
				
				addr = new Address();
				addr.setAddAddress(rs.getString("add_address"));
			}
			member.setAddressSet(addr);

			sql = "select * from att where mem_id = ?";
			 stmt = conn.prepareStatement(sql);
			 stmt.setString(1, id);

			 rs = stmt.executeQuery();
			 
			 Att att = new Att();
			 if(rs.next()) {
				 
				 att.setAttSeqno(rs.getInt("att_seqno"));
				 att.setAttName(rs.getString("att_name"));
				 att.savefilename(rs.getString("att_savename"));
				 att.setAttSize(rs.getString("att_size"));
				 att.setAttType(rs.getString("att_type"));
				 att.setAttPath(rs.getString("att_path"));

				 if(rs.getString("att_type").contains("image")) {
				 
					 sql = "select * from att_thumb where att_seqno = ?";
					 stmt = conn.prepareStatement(sql);
					 stmt.setString(1, rs.getString("att_seqno"));
					 ResultSet rs2 = stmt.executeQuery();
				 
					 while(rs2.next()) {
						 
						 Thumbnail th = new Thumbnail();
						 th.setThumbSeqNo(rs2.getString("thumb_seqno"));
						 th.setFileName(rs2.getString("thumb_filename"));
						 th.setFileSize(rs2.getString("thumb_filesize"));
						 th.setFilePath(rs2.getString("thumb_filepath"));
						 att.setAttThumb(th);
						 
					 }
					 
				 }
				 
			 }
			 
			 member.setAtt(att);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, cstmt);
		}
		return member;
	}

	public Mem info(String id) {
		
		PreparedStatement stmt = null;
		CallableStatement cstmt = null;
		Connection conn = null;
		
		Mem member = new Mem();
		
		String sql = "call p_info(?,?)";

		try {
			conn = ds.getConnection();
			
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, id);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.executeQuery();
			ResultSet rs = (ResultSet)cstmt.getObject(2);
			
			if(rs.next()) {
				member.setMemName(rs.getString("mem_name"));
				member.setMemEmail(rs.getString("mem_email"));
				member.setMemTel(rs.getString("mem_tel"));
				member.setMemSnsinfo(rs.getString("mem_snsinfo"));
				member.setMemImg(rs.getString("mem_img"));
				
				Address a = new Address();
				a.setAddAddress(rs.getString("add_address"));
				a.setAddCategory(rs.getString("add_category"));
				a.setAddPhone(rs.getString("add_phone"));
				a.setAddPerson(rs.getString("add_person"));
				a.setAddetail(rs.getString("add_detail"));
				member.setAddressSet(a);
				
			}
			
			sql = "select * from att where mem_id = ?";
			 stmt = conn.prepareStatement(sql);
			 stmt.setString(1, id);

			 rs = stmt.executeQuery();
			 
			 Att att = new Att();
			 if(rs.next()) {
				 
				 att.setAttSeqno(rs.getInt("att_seqno"));
				 att.setAttName(rs.getString("att_name"));
				 att.savefilename(rs.getString("att_savename"));
				 att.setAttSize(rs.getString("att_size"));
				 att.setAttType(rs.getString("att_type"));
				 att.setAttPath(rs.getString("att_path"));

				 if(rs.getString("att_type").contains("image")) {
				 
					 sql = "select * from att_thumb where att_seqno = ?";
					 stmt = conn.prepareStatement(sql);
					 stmt.setString(1, rs.getString("att_seqno"));
					 ResultSet rs2 = stmt.executeQuery();
				 
					 while(rs2.next()) {
						 
						 Thumbnail th = new Thumbnail();
						 th.setThumbSeqNo(rs2.getString("thumb_seqno"));
						 th.setFileName(rs2.getString("thumb_filename"));
						 th.setFileSize(rs2.getString("thumb_filesize"));
						 th.setFilePath(rs2.getString("thumb_filepath"));
						 att.setAttThumb(th);
						 
					 }
					 
				 }
				 
			 }
			 
			 member.setAtt(att);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, cstmt);
		}

		return member;
	}

	public List<Pro> membuylist(String id) {
		
		CallableStatement cstmt = null;
		Connection conn = null;
		
		List<Pro> pro = new ArrayList<Pro>();
		
		String sql = "call p_membuylist(?,?)";
		
		try {
			conn = ds.getConnection();
			
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, id);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.executeQuery();
			ResultSet rs = (ResultSet)cstmt.getObject(2);
			
			while(rs.next()) {
				Pro p = new Pro();
				p.setProSeqno(rs.getInt("rownum"));
				
				Item i = new Item();
				i.setItemImg(rs.getString("item_img"));
				i.setItemName(rs.getString("item_name"));
				
				Orders o = new Orders();
				o.setOrderDate(rs.getDate("order_date"));
				o.setOrderTotalprice(rs.getInt("order_totalprice"));
				o.setOrderAmount(rs.getInt("order_amount"));
				
				p.setOrdersSet(o);
				p.setItem(i);
				pro.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, cstmt);
		}
		
		
		return pro;
	}

	public Map<String, List<Cart>> memauclist(String id) {

		CallableStatement cstmt = null;
		Connection conn = null;
		
		Map<String, List<Cart>> auc = new HashMap<String, List<Cart>>();
		
		List<Cart> cart = new ArrayList<Cart>();
		List<Cart> cart2 = new ArrayList<Cart>();
		
		String sql = "call p_memauclist_end(?,?)";
		
		try {
			conn = ds.getConnection();
			
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, id);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.executeQuery();
			ResultSet rs = (ResultSet)cstmt.getObject(2);
			
			while(rs.next()) {
				Cart c = new Cart();
				c.setCartSeqno(rs.getInt("rownum"));
				
				Item i = new Item();
				i.setItemImg(rs.getString("item_img"));
				i.setItemName(rs.getString("item_name"));
				
				Orders o = new Orders();
				o.setOrderDate(rs.getDate("order_date"));
				o.setOrderTotalprice(rs.getInt("oreder_totalprice"));
				
				Auc a = new Auc();
				a.setAucStat(rs.getString("auc_stat"));

				Pro p = new Pro();
				p.setItem(i);
				c.setAuc(a);
				c.setPro(p);
				c.setOrdersSet(o);
				
				cart.add(c);
			}
			
			sql = "call p_memauclist_ing(?,?)";
			
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, id);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.executeQuery();
			rs = (ResultSet)cstmt.getObject(2);
			
			while(rs.next()) {
				Cart cc = new Cart();
				Auc a = new Auc();
				List<AucNowing> an = new ArrayList<AucNowing>();
				a.setAucSeqno(rs.getInt("rownum"));
				a.setAucImg(rs.getString("auc_img"));
				a.setAucCloseprice(rs.getInt("auc_closeprice"));
				a.setAucStat(rs.getString("auc_stat"));
				Item i = new Item();
				i.setItemName(rs.getString("auc_name"));
				
				AucNowing g = new AucNowing();
				g.setAucnowDate(rs.getDate("aucnow_date"));
				an.add(g);
				
				a.setItem(i);
				a.setAucNowingSet(an);
				
				cc.setAuc(a);
				cart2.add(cc);
			}
			
			auc.put("END", cart);
			auc.put("ING", cart2);
			
		} catch (SQLException e) {

			e.printStackTrace();
		
		} finally {
			
			resourceClose(conn, cstmt);
		}
		
		
		return auc;
	}

	public List<Pro> buystat(String id) {
		
		CallableStatement cstmt = null;
		Connection conn = null;
		
		List<Pro> pro = new ArrayList<Pro>();
		
		String sql = "call buystat(?,?)";

		try {
			conn = ds.getConnection();
			
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, id);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.executeQuery();
			ResultSet rs = (ResultSet)cstmt.getObject(2);
			
			while(rs.next()) {
				Pro p = new Pro();
				p.setProAmount(rs.getInt("rownum"));
				p.setProSeqno(rs.getInt("pro_seqno"));
				p.setProPrice(rs.getInt("pro_price"));
				
				Item i = new Item();
				i.setItemImg(rs.getString("item_img"));
				i.setItemName(rs.getString("item_name"));
				
				Orders o = new Orders();
				o.setOrderDate(rs.getDate("order_date"));
				
				Orderdetail d = new Orderdetail();
				d.setOrderdetailStat(rs.getString("orderdetail_stat"));
				
				o.setOrderdetailSet(d);
				p.setOrdersSet(o);
				p.setItem(i);
				
				pro.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			resourceClose(conn, cstmt);
		}
		return pro;
	}

	public Map<String, List<Ship>> ordercheck(String id) {
		
		CallableStatement cstmt = null;
		Connection conn = null;
		
		Map<String, List<Ship>> ship = new HashMap<String, List<Ship>>();
		
		List<Ship> detail = new ArrayList<Ship>();
		List<Ship> order = new ArrayList<Ship>();
		

		String sql = "call ordercheck_order(?,?)";

		try {
			conn = ds.getConnection();
			
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, id);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.executeQuery();
			ResultSet rs = (ResultSet)cstmt.getObject(2);
			
			while(rs.next()) {
				Ship s = new Ship();
				
				Orders o = new Orders();
				Orderdetail od = new Orderdetail();
				od.setOrderdetailWay(rs.getString("orderdetail_way"));
				o.setOrderdetailSet(od);
				s.setOrders(o);

				Address a = new Address();
				a.setAddAddress(rs.getString("add_address"));
				s.setAddress(a);
				
				Waybill w = new Waybill();
				w.setWaybillName(rs.getString("waybill_name"));
				w.setWaybillNumber(rs.getInt("waybill_number"));
				s.setWaybillSet(w);
				
				detail.add(s);
			}
			

			sql = "call ordercheck_detail(?,?)";

			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, id);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.executeQuery();
			rs = (ResultSet)cstmt.getObject(2);

			while(rs.next()) {
				Ship s = new Ship();
				s.setShipStatus(rs.getString("ship_status"));
				
				Orders o = new Orders();
				o.setOrderSeqno(rs.getInt("order_seqno"));
				o.setOrderDate(rs.getDate("order_date"));
				o.setOrderTotalprice(rs.getInt("order_totalprice"));
				s.setOrders(o);
				
				order.add(s);
			}
			
			ship.put("order", order);
			ship.put("detail", detail);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			resourceClose(conn, cstmt);
		}
		
		return ship;

	}

//	public void infoinsert(Mem mem) {
//		Address add = mem.getAddressSet();
//		Att att = mem.getAtt();
//		String sql = "call p_infoupdate(?,?,?,?,?,?,?,?,?)";
//		
//		try {
//			cstmt = conn.prepareCall(sql);
//			
//			
//			if( mem.getMemSnsinfo() != null) { 
//				cstmt.setString(1, mem.getMemSnsinfo());
//			} else { 
//				cstmt.setString(1, ""); 
//			}
//			
//			cstmt.setString(2, mem.getMemEmail());
//			cstmt.setString(3, mem.getMemTel());
//			cstmt.setString(4, mem.getMemId());
//			cstmt.setString(5, add.getAddCategory());
//			cstmt.setString(6, add.getAddPerson());
//			cstmt.setString(7, add.getAddPhone());
//			cstmt.setString(8, add.getAddAddress());
//			cstmt.setString(9, add.getAddetail());
//			
//			cstmt.executeQuery();
//			
//			//泥⑨옙??占쏙옙?占쏙옙
//			if(att != null) {
//				
//				sql = "INSERT INTO att(att_seqno, att_name, att_savename, att_size, att_type, att_path, mem_id)"
//						+ " VALUES (att_seqno.NEXTVAL, ?,?,?,?,?,?)";
//				
//				PreparedStatement stmt;
//				String attach_no = null;
//				stmt = conn.prepareStatement(sql);
//				stmt.setString(1, att.getAttName());
//				stmt.setString(2, att.getSavefilename());
//				stmt.setString(3, att.getAttSize());
//				stmt.setString(4, att.getAttType());
//				stmt.setString(5, att.getAttPath());
//				stmt.setString(6, mem.getMemId());
//				stmt.executeQuery();
//				
//				sql = "SELECT max(att_seqno) FROM att";
//				stmt = conn.prepareStatement(sql);
//				ResultSet rs = stmt.executeQuery();
//				rs.next();
//				attach_no = rs.getString(1);
//				
//				
//				String fileType = att.getAttType();
//				
//				//?占쏙옙?占쏙옙?占쏙옙
//				if(fileType.substring(0, fileType.indexOf("/")).equals("image")) {
//					sql = "INSERT INTO att_thumb (thumb_seqno, thumb_filename, thumb_filesize, thumb_filepath, att_seqno) "
//							+ " VALUES (thumb_seqno.nextval, ?, ?, ?, ?)";
//					Thumbnail thumb = att.getAttThumb();
//					stmt = conn.prepareStatement(sql);
//					stmt.setString(1, thumb.getFileName());
//					stmt.setString(2, thumb.getFileSize());
//					stmt.setString(3, thumb.getFilePath());
//					stmt.setString(4, attach_no);
//					stmt.executeQuery();
//				}
//			}
//			
//			cstmt.close();	
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	public void infoinsert(Mem mem) {
		
		CallableStatement cstmt = null;
		Connection conn = null;
		
		Address add = mem.getAddressSet();
		Att att = mem.getAtt();
		String sql = "call p_infoupdate(?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = ds.getConnection();
			cstmt = conn.prepareCall(sql);
		
			
			if( mem.getMemSnsinfo() != null) { 
				cstmt.setString(1, mem.getMemSnsinfo());
			} else { 
				cstmt.setString(1, ""); 
			}
			
			cstmt.setString(2, mem.getMemEmail());
			cstmt.setString(3, mem.getMemTel());
			cstmt.setString(4, mem.getMemId());
			cstmt.setString(5, add.getAddCategory());
			cstmt.setString(6, add.getAddPerson());
			cstmt.setString(7, add.getAddPhone());
			cstmt.setString(8, add.getAddAddress());
			cstmt.setString(9, add.getAddetail());
			
			cstmt.executeQuery();

			if(att != null) {
				
				sql = "call p_attinset(?,?)";
			
				StructDescriptor st_thumb = StructDescriptor.createDescriptor("OBJ_THUMB",conn);
				Object[] thumb_obj = {mem.getAtt().getAttThumb().getFileName(),
									  mem.getAtt().getAttThumb().getFileSize(),
									  mem.getAtt().getAttThumb().getFilePath()
									 };
				STRUCT thumb_rec = new STRUCT(st_thumb, conn, thumb_obj);
				
				StructDescriptor st_att = StructDescriptor.createDescriptor("OBJ_ATT",conn);
				Object[] att_obj = {mem.getAtt().getAttName(),
									mem.getAtt().getSavefilename(),
									mem.getAtt().getAttSize(),
									mem.getAtt().getAttType(),
									mem.getAtt().getAttPath(),
									thumb_rec
								   };
				STRUCT att_rec = new STRUCT(st_att, conn, att_obj);
				
				cstmt = conn.prepareCall(sql);
				cstmt.setObject(1, att_rec);
				cstmt.setString(2, mem.getMemId());
				
				cstmt.executeQuery();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			resourceClose(conn, cstmt);
		}
		
	}

	public Map<String, String> changePw(String new_pw, String id, String now_pw) {

		PreparedStatement stmt = null;
		Connection conn = null;
		
		Map<String, String> map = new HashMap<String, String>();
		
		String sql = "select mem_id, mem_pw from mem where mem_id = ? ";
		
			try {
				conn = ds.getConnection();
				
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, id);

				ResultSet rs = stmt.executeQuery();
				
			
				
				if(rs.next()) {
					
					if(rs.getString("mem_pw").equals(now_pw)) {
						sql = "update mem set mem_pw = ? where mem_id = ?";
						
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, new_pw);
						stmt.setString(2, id);
						
						stmt.executeQuery();
						
						//鍮꾬옙?踰덊샇 占�?占�? ?占쏙옙占�?
						map.put("change", "ok");
						
					} else {
						//鍮꾬옙?踰덊샇 占�?占�? ?占쏙옙?占쏙옙
						map.put("change", "pwfail");
					}
					
				} else {
					map.put("change", "no_member");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				resourceClose(conn, stmt);
			}
			
			return map;

		
	}

	public Map<String, String> findId(String idemail) {
		PreparedStatement stmt = null;
		Connection conn = null;
		
		Map<String, String> map = new HashMap<String, String>();
		
		String sql = "select mem_id,mem_email from mem where mem_email = ? ";
		
		try {
			conn = ds.getConnection();
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, idemail);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				
				if(rs.getString("mem_email").equals(idemail)) {
					//二쇱냼?占쏙옙占�?
					map.put("find", "ok");
					map.put("lostid", rs.getString("mem_id"));
				} else {
					//鍮꾬옙?踰덊샇 占�?占�? ?占쏙옙?占쏙옙
					map.put("find", "pwfail");
				}
				
			} else {
				map.put("find", "no_member");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		
		
		return map;
	}

	public Map<String, String> findPw(String id, String email) {
		PreparedStatement stmt = null;
		Connection conn = null;
		
		Map<String, String> map = new HashMap<String, String>();
		
		String sql = "select mem_id,mem_email,mem_pw from mem where mem_email = ? and mem_id = ?";
		try {
			conn = ds.getConnection();
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, email);
			stmt.setString(2, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				
				if(rs.getString("mem_id").equals(id)) {
					
					if(rs.getString("mem_email").equals(email)) {
						
						map.put("find", "ok");
						map.put("lostpw", rs.getString("mem_pw"));
						
					} else {
						map.put("find", "pwfail");
						
					}
					
				} else {
					map.put("find", "no_member");
				}
			}	else {
				
				map.put("find", "null");

			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		
		
		
		return map;
	}

	public int checkid(String id) {
		PreparedStatement stmt = null;
		Connection conn = null;
		
		int rs = 0;
		String sql ="select mem_id from mem where mem_id = ?";
		
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, id);
			
			ResultSet res = stmt.executeQuery();
			if(res.next()) {
				rs = 1;
			} else {
				rs = 0;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			resourceClose(conn, stmt);
		}
		
		return rs;
		
	}
	
	private void resourceClose(Connection conn, PreparedStatement stmt) {
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
	
	private void resourceClose(Connection conn, CallableStatement cstmt) {
		//�옄�썝諛섎궔
		try {
			
			if(cstmt != null || conn != null) {
				cstmt.close();
				conn.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}	
}
