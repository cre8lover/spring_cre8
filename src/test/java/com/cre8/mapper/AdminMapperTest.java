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
import com.cre8.dto.Marketing;
import com.cre8.dto.MarketingVo;
import com.cre8.dto.Mem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class AdminMapperTest {

	private static final Logger log = LoggerFactory.getLogger("MemberMapperTest.class");
	
	@Autowired
	private AdminMapper mapper;
	
	@Test
	public void marlist() {
		
		AdminKeyWord adkey = new AdminKeyWord();
		adkey.setClassification("mar_product");
		adkey.setKeyword("%요%");
		List<MarketingVo> m = mapper.marketingList(adkey);
		
		for(MarketingVo list : m) {
			log.info("마케팅 대표 : " + list.getMarCeo());
		}
	}
	
	@Test
	public void marChange() {
		MarketingVo m = new MarketingVo();
		m.setMarSeqno(3);
		m.setMarCategory("test...");
		m.setMarCeo("3");
		m.setMarClosedate("220309");
		m.setMarCompany("3");
		m.setMarDetail("3");
		m.setMarOpendate("220101");
		m.setMarPhone("010-1234-5678");
		m.setMarPrice("3");
		m.setMarProduct("4");
		m.setMarRegnum("353-74435");
		
		mapper.marketReg(m);
	}
}
