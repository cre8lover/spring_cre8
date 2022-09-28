package com.cre8.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class prodelVo implements Serializable {

	private static final long serialVersionUID = 1L;
		private Integer proSeqno;
		private Integer attSeqno;
		private Integer itemSeqno;
		private Integer cartSeqno;
		
		
		
		public Integer getProSeqno() {
			return proSeqno;
		}
		public void setProSeqno(Integer proSeqno) {
			this.proSeqno = proSeqno;
		}
		public Integer getAttSeqno() {
			return attSeqno;
		}
		public void setAttSeqno(Integer attSeqno) {
			this.attSeqno = attSeqno;
		}
		public Integer getItemSeqno() {
			return itemSeqno;
		}
		public void setItemSeqno(Integer itemSeqno) {
			this.itemSeqno = itemSeqno;
		}
		public Integer getCartSeqno() {
			return cartSeqno;
		}
		public void setCartSeqno(Integer cartSeqno) {
			this.cartSeqno = cartSeqno;
		}
		
		
}