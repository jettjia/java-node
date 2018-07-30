package com.jettjia.filterdemo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 统一全站字符集，解决中文乱码问题
 */
public class CharacterEncodingFilter implements Filter {
	private FilterConfig filterConfig = null;
	// 设置默认字符集
	private String defaultCharset = "UTF-8";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 得到过滤器的初始化配置信息
		this.filterConfig = filterConfig;
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		// 获取访问资源的字符集
		String charset = filterConfig.getInitParameter("charset");
		if (charset == null){
			charset = defaultCharset;
		}
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		response.setContentType("text/html;charset=" + charset);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}
