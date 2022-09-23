package com.cre8.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TimeMapperTest {

	private static final Logger log = LoggerFactory.getLogger("TimeMapperTest.class");
	
	@Autowired
	private TimeMapper tm;
	
	@Test
	public void test() {
		log.info(tm.getTime());
		
	}

}
