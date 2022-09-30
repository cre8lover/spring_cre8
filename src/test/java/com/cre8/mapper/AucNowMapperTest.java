package com.cre8.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cre8.dto.AucNowVO;
import com.cre8.dto.CartlistVO;




@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AucNowMapperTest {

	private static final Logger log = LoggerFactory.getLogger("AucNowMapperTest.class");
	
	@Autowired
	private AucNowMapper am;
	

	
	@Test
	public void testList() {
		AucNowVO auc = new AucNowVO();
		auc.setId("ccc");
		auc.setPrice("5000");
		auc.setAucseqno("3");
		log.info("여기까지");
		int rs = am.aucnowadd(auc);
		log.info("rs"+rs);
	}
}
