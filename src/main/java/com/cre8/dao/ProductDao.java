package com.cre8.dao;

import java.util.List;

import com.cre8.dto.Pro;

public interface ProductDao {
	public List<Pro> proList_clothes();
	public List<Pro> proList_furn();
	public List<Pro> proList_cos();
	public List<Pro> proList_interior();
	public List<Pro> proList_tra();
	public Pro detailList(String seqno);
}
