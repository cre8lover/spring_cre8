package com.cre8.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cre8.dto.AdminKeyWord;
import com.cre8.dto.Cat;
import com.cre8.dto.Marketing;
import com.cre8.dto.Mem;

public interface AdminMapper {
	
	public List<Marketing> marketinglist(AdminKeyWord adkey);

	public void marketReg(Marketing market);

}
