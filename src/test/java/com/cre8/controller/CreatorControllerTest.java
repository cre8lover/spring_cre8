package com.cre8.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
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
public class CreatorControllerTest {

	private static final Logger log = LoggerFactory.getLogger("CreatorControllerTest.class");
	
	@Inject
	private WebApplicationContext wac;
	//요청과 응답 처리
	private MockMvc mockMvc;
	//junit 임포트
	
	protected MockHttpSession session;
	protected MockHttpServletRequest request;
	
	@Before
	public void setup() {
		session = new MockHttpSession();
		session.setAttribute("sess_id", "ddd");
		session.setAttribute("auth", "C");
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		log.info("mockMvc setup...");
		
	}
	
	@After
	public void clear(){
	    session.clearAttributes();
	    session = null;
	}
	
	@Test
	public void test() {
		try {
			String rs = mockMvc.perform(MockMvcRequestBuilders.get("/cre/creReg")
					.param("id", "ddd").session(session))
					.andReturn().getModelAndView().getViewName();
			log.info(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}