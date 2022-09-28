package com.cre8.mapper;

import org.apache.ibatis.annotations.Param;

import com.cre8.dto.Att;
import com.cre8.dto.Creator;
import com.cre8.dto.Marketing;
import com.cre8.dto.Pro;

public interface CreatorMapper {
	
	public void Creatoradd(Creator cre);

	public void mk(Marketing m);

	public int cremodifyreg(Pro p);

	public int prodel(String seqno);
	
}
