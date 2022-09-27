package com.cre8.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cre8.dto.Creator;
import com.cre8.dto.Mem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class CreatorMapperTest {

	private static final Logger log = LoggerFactory.getLogger("CreatorMapperTest.class");
	
	@Autowired
	private CreatorMapper mapper;
	
	@Test
	public void test() {
		Creator c = new Creator();
		Mem m = new Mem();
		c.setCreCompany("취업이될까요");
		c.setCrePhone("01011111111");
		c.setCreName("들어감?");
		c.setCreAddress("영통구");
		c.setCreRegnum("02-0230233");
		c.setCreSalenum("123-1231332");
		c.setCrePot("안녕하세요");
		m.setMemId("test");
		c.setMem(m);
		mapper.Creatoradd(c);
	}
	
}
