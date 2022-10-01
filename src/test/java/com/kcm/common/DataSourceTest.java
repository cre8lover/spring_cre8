package com.kcm.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DataSourceTest {

	private static final Logger log = LoggerFactory.getLogger("DataSourceTest.class");
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void test() {
		
		try {
			Connection conn = ds.getConnection();
			log.info(conn.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}








