package com.cre8.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cre8.dto.AdminKeyWord;
import com.cre8.dto.Att;
import com.cre8.dto.Cat;
import com.cre8.dto.Marketing;
import com.cre8.dto.MarketingVo;
import com.cre8.dto.Mem;

public interface AdminMapper {
	
	public List<MarketingVo> marketingList(
						@Param("adkey") AdminKeyWord adkey);

	public int marketReg(MarketingVo vo);

	public MarketingVo get(String marSeqno);

	public int remove(Long marSeqno);

	public int getCountMarketing();


}
