package com.jettjia.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo implements Filter {

	@Override
	public void destroy() {
		System.out.println("过滤器销毁...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 // 对request和response进行一些预处理
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("FilterDemo01执行前！！！");
		chain.doFilter(request, response);  //让目标资源执行，放行
		System.out.println("FilterDemo01执行后！！！");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("过滤器创建了...");
	}


}
