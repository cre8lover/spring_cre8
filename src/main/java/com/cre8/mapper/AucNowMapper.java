<<<<<<< HEAD
package com.cre8.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cre8.dto.AucNowListVO;
import com.cre8.dto.AucNowVO;
import com.cre8.dto.Auc_Criteria;

public interface AucNowMapper {

	public int aucnowadd(AucNowVO aucnow);

	public List<AucNowListVO> aucnowlist(@Param("cri") Auc_Criteria cri, @Param("bno") long bno);

	public int total(long bno);
	
}
=======
package com.cre8.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cre8.dto.AucNowListVO;
import com.cre8.dto.AucNowVO;
import com.cre8.dto.Auc_Criteria;

public interface AucNowMapper {

	public int aucnowadd(AucNowVO aucnow);

	public List<AucNowListVO> aucnowlist(@Param("cri") Auc_Criteria cri, @Param("bno") long bno);

	public int total(long bno);
	
}
>>>>>>> branch 'master' of https://github.com/cre8lover/spring_cre8.git
