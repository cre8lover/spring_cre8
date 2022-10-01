<<<<<<< HEAD
package com.cre8.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BuyControllerTest {

	private static final Logger log = LoggerFactory.getLogger("BuyControllerTest.class");
	
	@Inject
	private WebApplicationContext wac;
	//요청과 응답 처리
	private MockMvc mockMvc;
	//junit 임포트
	
	protected MockHttpSession session;
	
	@Before
	public void setup() {
		session = new MockHttpSession();
		session.setAttribute("sess_id", "aaa");
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		log.info("mockMvc setup...");
		
	}
	
	@After
	public void clear(){
	    session.clearAttributes();
	    session = null;
	}
	
	@Test
	public void carttest() {
		List<String> seqno = new ArrayList<String>();
		seqno.add("13");
		seqno.add("14");
		try {
			String rs = mockMvc.perform(MockMvcRequestBuilders.post("/buyer/cart")
					.session(session).requestAttr("allponecheck", seqno))
					.andReturn().getModelAndView().getViewName();
			log.info(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void buytest() {
		try {
			String rs = mockMvc.perform(MockMvcRequestBuilders.get("/buyer/buy").param("seqno", "13").session(session))
					.andReturn().getModelAndView().getViewName();
			log.info(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
//	@Test
//	public void orderadd() {
//		private String[] cart;
//		private String[] orderamount;
//		private String pay_method;
//		private String buyer_name;
//		private String buyer_tel;
//		private String merchant_uid;
//		private String amount;
//		private String id;
//		
//		try {
//			String rs = mockMvc.perform(MockMvcRequestBuilders.get("/buyer/order").param("money", "3000").param("seqno","13")
//					.session(session).)
//					.andReturn().getModelAndView().getViewName();
//			log.info(rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//	}
}
=======
package com.cre8.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BuyControllerTest {

	private static final Logger log = LoggerFactory.getLogger("BuyControllerTest.class");
	
	@Inject
	private WebApplicationContext wac;
	//요청과 응답 처리
	private MockMvc mockMvc;
	//junit 임포트
	
	protected MockHttpSession session;
	
	@Before
	public void setup() {
		session = new MockHttpSession();
		session.setAttribute("sess_id", "aaa");
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		log.info("mockMvc setup...");
		
	}
	
	@After
	public void clear(){
	    session.clearAttributes();
	    session = null;
	}
	
	@Test
	public void carttest() {
		List<String> seqno = new ArrayList<String>();
		seqno.add("13");
		seqno.add("14");
		try {
			String rs = mockMvc.perform(MockMvcRequestBuilders.post("/buyer/cart")
					.session(session).requestAttr("allponecheck", seqno))
					.andReturn().getModelAndView().getViewName();
			log.info(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void buytest() {
		try {
			String rs = mockMvc.perform(MockMvcRequestBuilders.get("/buyer/buy").param("seqno", "13").session(session))
					.andReturn().getModelAndView().getViewName();
			log.info(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
//	@Test
//	public void orderadd() {
//		private String[] cart;
//		private String[] orderamount;
//		private String pay_method;
//		private String buyer_name;
//		private String buyer_tel;
//		private String merchant_uid;
//		private String amount;
//		private String id;
//		
//		try {
//			String rs = mockMvc.perform(MockMvcRequestBuilders.get("/buyer/order").param("money", "3000").param("seqno","13")
//					.session(session).)
//					.andReturn().getModelAndView().getViewName();
//			log.info(rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//	}
}
>>>>>>> branch 'master' of https://github.com/cre8lover/spring_cre8.git
