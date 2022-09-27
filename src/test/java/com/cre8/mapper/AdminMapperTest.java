package com.cre8.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cre8.dto.AdminKeyWord;
import com.cre8.dto.Cat;
import com.cre8.dto.Mem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class AdminMapperTest {

	private static final Logger log = LoggerFactory.getLogger("MemberMapperTest.class");
	
	@Autowired
	private AdminMapper mapper;
	
	@Test
	public void test() {
		Mem m = mapper.longinProc("bbb","1234");
		
		log.info(m.getMemName());
	}
	
	@Test
	public void test2() {
		
		AdminKeyWord adkey = new AdminKeyWord("1","의");
		List<Cat> c = mapper.categoryList(adkey);
		
		for(Cat list : c) {
			log.info("카테고리 이름 : " + list.getCatName());
		}
	}
	
}
