package com.cre8.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

public class CharacterEncodingFilter implements Filter {
       
	private String encoding = null;
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		
		this.encoding = fConfig.getInitParameter("encoding"); //"encoding"은 web.xml에 있는 init-param를 적어줌
		System.out.println(fConfig.getFilterName() + "필터가 시작되었습니다.");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if(encoding != null) {
			//요청과 응답을 모두 encoding을 사용하겠다고 설정
			request.setCharacterEncoding(encoding);
			response.setCharacterEncoding(encoding);
		}
		
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}

}
