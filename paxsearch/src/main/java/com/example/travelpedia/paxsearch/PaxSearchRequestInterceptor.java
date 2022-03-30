package com.example.travelpedia.paxsearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class PaxSearchRequestInterceptor implements HandlerInterceptor{
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		StringBuffer reqSbuf = new StringBuffer();
		Iterator<String> it = request.getHeaderNames().asIterator();
		String nextHeaderName = "";
		while(it.hasNext()) {
			nextHeaderName = it.next();
			reqSbuf.append(nextHeaderName+": "+request.getHeader(nextHeaderName)+" ");
		}
		reqSbuf.append(request.getMethod()+" ");
		reqSbuf.append(request.getRequestURL());
		reqSbuf.append(request.getQueryString());
		BufferedReader reqBr = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String nextReqLine = reqBr.readLine();
		while(nextReqLine != null) {
			reqSbuf.append(nextReqLine);
			nextReqLine = reqBr.readLine();
		}
		// TODO Auto-generated method stub
		logger.debug("---P1---"+reqSbuf.toString());
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	

}
