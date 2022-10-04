package com.cre8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cre8.dto.Auc_Criteria;
import com.cre8.dto.ProductMainVO;
import com.cre8.dto.ProductTotalVO;
import com.cre8.mapper.MainMapper;

@Service
public class MainListRestServiceImp implements MainListRestService {

	@Autowired
	private MainMapper mapper;

	@Override
	public ProductTotalVO getList(Auc_Criteria maincriteria) {
		return new ProductTotalVO (mapper.total(maincriteria),mapper.list(maincriteria));
	}

}
