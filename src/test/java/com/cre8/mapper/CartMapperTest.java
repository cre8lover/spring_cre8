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

import com.cre8.dto.CartlistVO;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CartMapperTest {

	private static final Logger log = LoggerFactory.getLogger("CartMapperTest.class");
	
	@Autowired
	private cartMapper cm;
	
	@Test
	public void test() {
		List<String> a = new ArrayList<>();
		a.add("13");
		a.add("14");
		int i = cm.delete(a);
		log.info(""+i);
	}
	
	
	@Test
	public void testList() {
		List<CartlistVO> list = cm.list("ccc");
		for (CartlistVO i : list) {
			log.info("댓글내용:"+i.getItemName());
		}
	}
}
