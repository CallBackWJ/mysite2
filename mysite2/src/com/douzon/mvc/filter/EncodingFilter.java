package com.douzon.mvc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//@WebFilter("/")
public class EncodingFilter implements Filter {

	String encoding;
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//request 처리 부분

		
		request.setCharacterEncoding(encoding);

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		//response 처리
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		System.out.println("Encoding filter is initialized");
		encoding=fConfig.getInitParameter("encoding");
		if(encoding==null)
			encoding="UTF-8";
	}

}
