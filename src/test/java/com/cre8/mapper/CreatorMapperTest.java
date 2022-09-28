package com.cre8.mapper;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cre8.dto.Att;
import com.cre8.dto.Creator;
import com.cre8.dto.Marketing;
import com.cre8.dto.Mem;
import com.cre8.dto.Pro;
import com.cre8.dto.prodelVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class CreatorMapperTest {

	private static final Logger log = LoggerFactory.getLogger("CreatorMapperTest.class");
	
	@Autowired
	private CreatorMapper mapper;
	
	//크리에이터 가입
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
	
	//마케팅 리스트 조회
	@Test
	public void test1() {
		Marketing m = new Marketing();
		m.setMarSeqno(13);
		m.setMarProduct("짠짠");
		m.setMarImg("호이");
		m.setMarPrice("100000");
		mapper.mk(m);
		
		log.info("마케팅 가격" + m.getMarPrice());
		
	}
	
	//수정
	@Test
	public void testupdate() {
		Pro p = new Pro(); 
		p.setProSeqno(1); //아무거나 댓글 seqno있는것
		p.setProPrice(30000);
		int count = mapper.cremodifyreg(p);
		log.info("update count : " + count);
	}
	
	//삭제
	@Test
	public void testdelete(prodelVo seqno) {
		prodelVo p = new prodelVo();
		mapper.prodel(p);
	}
	
	
}
