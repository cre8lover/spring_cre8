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
//		System.out.println("?ù∏ÏΩîÎî© ?ïÑ?Ñ∞ Ï¢ÖÎ£å : destroy() ?ò∏Ï∂?");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("doFilter() ?ò∏Ï∂?");
		//?öîÏ≤??ïÑ?Ñ∞ Í∏∞Îä•
		request.setCharacterEncoding(config.getInitParameter("encoding"));
		chain.doFilter(request, response);
		//?ùë?ãµ?ïÑ?Ñ∞ Í∏∞Îä•
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
//		System.out.println("?ù∏ÏΩîÎî© Ï¥àÍ∏∞Í∞? ?Ñ§?†ï : init() ?ò∏Ï∂?");
	
	}

}
