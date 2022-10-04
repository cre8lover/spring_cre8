package com.cre8.service;

import java.util.List;

import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.ProductMainVO;
import com.cre8.dto.ProductTotalVO;

public interface MainListRestService {
	public ProductTotalVO getList(Auc_Criteria maincriteria);
	
}
