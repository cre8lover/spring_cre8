package com.cre8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cre8.dto.AucNowListVO;
import com.cre8.dto.AucNowTotalVO;
import com.cre8.dto.AucNowVO;
import com.cre8.dto.Auc_Criteria;
import com.cre8.mapper.AucNowMapper;

@Service
public class AucNowServiceimp implements AucNowService {

	@Autowired
	private AucNowMapper mapper;
	
	@Override
	public int priceadd(AucNowVO aucnow) {
		return mapper.aucnowadd(aucnow);
	}

	@Override
	public AucNowTotalVO getList(Auc_Criteria cri, long bno) {
		return new AucNowTotalVO (mapper.aucnowlist(cri, bno), mapper.total(bno));
	}

}
