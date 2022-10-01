package com.cre8.controller;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.cre8.dto.MarketingVo;
import com.google.gson.Gson;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class AdminControllerTest {

	private static final Logger log = LoggerFactory.getLogger("AdminControllerTest.class");
	
	@Inject
	private WebApplicationContext wac;
	//占쎌뒄筌ｏ옙�⑨옙 占쎌벓占쎈뼗 筌ｌ꼶�봺
	private MockMvc mockMvc;
	//junit 占쎌뿫占쎈７占쎈뱜
	
//	MockMultipartFile image = new MockMultipartFile("files", "imagefile.jpeg", "image/jpeg", "<<jpeg data>>".getBytes());
	
	protected MockHttpSession session;
	protected MockHttpServletRequest request;
	
	
	
	@Before
	public void setup() {
		session = new MockHttpSession();
		session.setAttribute("sess_id", "ddd");
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		log.info("mockMvc setup...");
		
	}
	
	@After
	public void clear(){
	    session.clearAttributes();
	    session = null;
	}
	
	@Test
	public void marektinglistTest() {
		try {
			String rs = mockMvc.perform(MockMvcRequestBuilders.get("/master/creAd")
										.param("keyword", "0")
										).andReturn().getModelAndView().getViewName();
			
			log.info(rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void marketingChange() {
		
		MarketingVo vo = new MarketingVo();
		vo.setCategory("2");
		vo.setMarCompany("2");
		vo.setMarCeo("2");
		vo.setMarRegnum("2");
		vo.setMarPhone("2");
		vo.setMarOpendate("11/11/11");
		vo.setMarClosedate("12/12/12");
		vo.setMarDetail("dd");
		vo.setMarProduct("2");
		vo.setMarPrice("2");
		
		String json = new Gson().toJson(vo);
		
		try {
			 mockMvc.perform(MockMvcRequestBuilders
					 		.post("/master/add")
					 		.content("application/json; charset=utf-8")
					 		.content(json)
					 		.session(session));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
