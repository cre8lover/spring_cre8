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
//		System.out.println("?Έμ½λ© ??° μ’λ£ : destroy() ?ΈμΆ?");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("doFilter() ?ΈμΆ?");
		//?μ²???° κΈ°λ₯
		request.setCharacterEncoding(config.getInitParameter("encoding"));
		chain.doFilter(request, response);
		//??΅??° κΈ°λ₯
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
//		System.out.println("?Έμ½λ© μ΄κΈ°κ°? ?€?  : init() ?ΈμΆ?");
	
	}

}
