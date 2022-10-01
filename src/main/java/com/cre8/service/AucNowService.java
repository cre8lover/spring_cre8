package com.cre8.service;


import java.util.List;

import com.cre8.dto.AucNowListVO;
import com.cre8.dto.AucNowTotalVO;
import com.cre8.dto.AucNowVO;
import com.cre8.dto.Auc_Criteria;

public interface AucNowService {

	int priceadd(AucNowVO aucnow);
	/* List<CartlistVO> getList(String id); */

	AucNowTotalVO getList(Auc_Criteria cri, long bno);

}
