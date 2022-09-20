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
		
		this.encoding = fConfig.getInitParameter("encoding"); //"encoding"�� web.xml�� �ִ� init-param�� ������
		System.out.println(fConfig.getFilterName() + "���Ͱ� ���۵Ǿ����ϴ�.");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if(encoding != null) {
			//��û�� ������ ��� encoding�� ����ϰڴٰ� ����
			request.setCharacterEncoding(encoding);
			response.setCharacterEncoding(encoding);
		}
		
		chain.doFilter(request, response);
	}

	public void destroy() {
		
	}

}
