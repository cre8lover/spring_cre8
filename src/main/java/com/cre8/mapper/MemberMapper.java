package com.cre8.mapper;

import org.apache.ibatis.annotations.Param;

import com.cre8.dto.Mem;

public interface MemberMapper {
	
	public Mem longinProc(
					@Param("memIds") String id,
					@Param("memPw") String pw);
	
}
