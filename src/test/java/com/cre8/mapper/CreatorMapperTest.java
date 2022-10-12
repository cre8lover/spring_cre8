package com.cre8.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cre8.dto.Creator;
import com.cre8.dto.Marketing;
import com.cre8.dto.Mem;
import com.cre8.dto.prodelVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class CreatorMapperTest {

	private static final Logger log = LoggerFactory.getLogger("CreatorMapperTest.class");
	
	@Autowired
	private CreatorMapper mapper;
	
//	//크리에이터 등록
//	@Test
//	public void test() {
//		Creator c = new Creator();
//		Mem m = new Mem();
//		c.setCreCompany("취업이될까요!?");
//		c.setCrePhone("01011111111");
//		c.setCreName("들어감??");
//		c.setCreAddress("영통구");
//		c.setCreRegnum("02-023022");
//		c.setCreSalenum("123-1233332");
//		c.setCrePot("안녕하세요");
//		m.setMemId("cmcm");
//		c.setMem(m);
//		mapper.add(c);
//	}
//	
//	
//	
//	//마케팅 리스트 조회
//	@Test
//	public void test1() {
//		List<Marketing> m = mapper.getlist();
//		for (Marketing mk : m) {
//			log.info("마케팅 가격" + mk.getMarPrice());
//		}
//	}
//	
//	
//	//크리에이터 정보수정
//	@Test
//	public void testupdate() {
//		Creator c = new Creator();
//		c.setCreCompany("수달이네회사");
//		c.setCrePhone("01056665555");
//		c.setCreName("김수달");
//		c.setCreAddress("성남시어딘가");
//		c.setCreRegnum("56-0484-45");
//		c.setCreSalenum("56-7979-7979");
//		c.setCrePot("잘부탁드립니다");
//		c.setMemid("ddd");
//		
//		int rs = mapper.infomodify(c);
//		log.info("크리에이터 정보 : " +rs);
//	}
//	
	
	
//	//일반물품삭제
//	@Test
//	public void testdelete() {
//		int rs = mapper.prodel("38");
//		log.info(Integer.toString(rs));
//	}
	
	
}
