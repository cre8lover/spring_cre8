package com.cre8.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "utf-8")
		})
public class CharacterEncodingFilter extends HttpFilter implements Filter {
	
	FilterConfig config;
	
    public CharacterEncodingFilter() {
        super();
    }

	public void destroy() {
//		System.out.println("?��코딩 ?��?�� 종료 : destroy() ?���?");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("doFilter() ?���?");
		//?���??��?�� 기능
		request.setCharacterEncoding(config.getInitParameter("encoding"));
		chain.doFilter(request, response);
		//?��?��?��?�� 기능
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
//		System.out.println("?��코딩 초기�? ?��?�� : init() ?���?");
	
	}

}
