package com.cre8.mapper;

import java.util.List;

import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.CartlistVO;
import com.cre8.dto.ProductMainVO;

public interface MainMapper {

	public List<ProductMainVO> list(Auc_Criteria maincriteria);

	public int total(Auc_Criteria maincriteria);
	
}
