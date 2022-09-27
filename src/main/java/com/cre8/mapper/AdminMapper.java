package com.cre8.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cre8.dto.AdminKeyWord;
import com.cre8.dto.Cat;
import com.cre8.dto.Mem;

public interface AdminMapper {
	
	public Mem longinProc(
					@Param("memId") String id,
					@Param("memPw") String pw);

	public List<Cat> categoryList(AdminKeyWord adkey);
	
}
