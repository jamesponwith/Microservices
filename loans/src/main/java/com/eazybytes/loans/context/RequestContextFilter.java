package com.drspeedracer.loans.context;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestContextFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(RequestContextFilter.class);

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

		RequestContextHolder.getContext().setCorrelationId(httpServletRequest.getHeader(RequestContext.CORRELATION_ID));

		logger.debug("Loans Service incoming Correlation id: {}", RequestContextHolder.getContext().getCorrelationId());
		filterChain.doFilter(httpServletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
