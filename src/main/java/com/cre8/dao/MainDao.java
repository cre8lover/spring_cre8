package com.cre8.dao;

import java.util.HashMap;
import java.util.List;

import com.cre8.dto.Creator;
import com.cre8.dto.Pro;

public interface MainDao {

	List<Pro> mainList();

	Creator detailcre(String memid);

	HashMap<String, List<Creator>> creList();

}
