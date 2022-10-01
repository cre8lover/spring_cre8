package com.cre8.RestController;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.cre8.dto.CartlistVO;
import com.google.gson.Gson;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class CartControllerTest {

	private static final Logger log = LoggerFactory.getLogger("CartControllerTest.class");
	
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
		session.setAttribute("sess_id", "ccc");
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		log.info("mockMvc setup...");
		
	}
	
	@After
	public void clear(){
	    session.clearAttributes();
	    session = null;
	}
	
	@Test
	public void cartlist() {
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/cart/list/ccc").accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
					).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void delete() {
		String[] seqno = {"13"};
		
		Gson g = new Gson();
		String go = g.toJson(seqno);
		
		try {
			mockMvc.perform(MockMvcRequestBuilders.delete("/cart/delete").content(go).contentType("application/json")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
