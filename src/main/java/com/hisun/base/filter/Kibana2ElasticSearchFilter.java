package com.hisun.base.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Kibana2ElasticSearchFilter implements Filter {
	
	private static final Logger logger = Logger.getLogger(Kibana2ElasticSearchFilter.class);
	private FilterConfig filterConfig;
	
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain filterChain) {
		String fullPath = null;
		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			fullPath = req.getServletPath();
		    
			//UserLoginDetails userDetails = UserLoginDetailsUtil.getUserLoginDetails();
			
			Pattern patternAliasesAll = Pattern.compile("^/_aliases$");
			Pattern patternAliases = Pattern.compile("^/.*/_aliases$");
			Pattern patternNode = Pattern.compile("^/_nodes$");
			Pattern patternSearch = Pattern.compile("^/.*/_search$");
			Pattern patternMapping = Pattern.compile("^/.*/_mapping.*");					
			Pattern patternDashboard = Pattern.compile("^/kibana-int/dashboard/.*$");
			Pattern patternTemp = Pattern.compile("^/kibana-int/temp.*$");
			
			Matcher matcherAliases = patternAliases.matcher(fullPath);
			Matcher matcherAliasesAll = patternAliasesAll.matcher(fullPath);
			Matcher matcherNode = patternNode.matcher(fullPath);
			Matcher matcherSearch = patternSearch.matcher(fullPath);
			Matcher matcherMapping = patternMapping.matcher(fullPath);
			Matcher dashboardMapping = patternDashboard.matcher(fullPath);
			Matcher tempMapping = patternTemp.matcher(fullPath);

			/*
			路径示例：
				http://localhost:8080/ilmusic/video/video.do
				request.getRequestURL():  http://localhost:8080/ilmusic/video/video.do
				request.getRequestURI():  /ilmusic/video/video.do
				request.getContextPath(): /ilmusic
				request.getServletPath(): /video/video.do
			 */
			String requestUri = req.getRequestURI();
			String originalServletPath = req.getServletPath();
			
			
			req.setAttribute("originalUrl", requestUri);
			req.setAttribute("originalServletPath", originalServletPath);

			
			if (matcherNode.matches())
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("/_nodes");
			    dispatcher.forward( req, res); 
			}
			else if (matcherAliases.matches() || matcherAliasesAll.matches())
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("/_aliases");
			    dispatcher.forward( req, res); 
			}
			else if (matcherMapping.matches())
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("/_mapping");
			    dispatcher.forward( req, res); 						
			}
			else if (matcherSearch.matches())
			{						
				RequestDispatcher dispatcher = req.getRequestDispatcher("/_search");
			   
			    //String method = req.getMethod();
			    int size = request.getContentLength();
			    InputStream is = request.getInputStream();
			    byte[] reqBodyBytes = readBytes(is, size);
                String body = new String(reqBodyBytes);
                
				req.setAttribute("originalBody", body);

                dispatcher.forward( req , res);					
            }
			else if (dashboardMapping.matches())
			{						
				RequestDispatcher dispatcher = req.getRequestDispatcher("/kibana-int/dashboard");
				
				int size = request.getContentLength();
			    InputStream is = request.getInputStream();
			    byte[] reqBodyBytes = readBytes(is, size);
                String body = new String(reqBodyBytes);
                
				req.setAttribute("originalBody", body);
				
				dispatcher.forward( req , res);					
			}
			else if (tempMapping.matches())
			{						
				RequestDispatcher dispatcher = req.getRequestDispatcher("/temp");
				dispatcher.forward( req , res);					
			}
			else
			{
				filterChain.doFilter(request, response);
			}
		
		} catch (ServletException sx) {
			logger.error(sx,sx);
			filterConfig.getServletContext().log(sx.getMessage());
		} catch (IOException iox) {
			logger.error(iox,iox);
			filterConfig.getServletContext().log(iox.getMessage());
		}
		
		
	}

	
	public void destroy() {
		//nothing
	}
	
	public static final byte[] readBytes(InputStream is, int contentLen) throws IOException {
		if (contentLen > 0) {
			int readLen = 0;
			int readLengthThisTime = 0;
			byte[] message = new byte[contentLen];
			while (readLen != contentLen) {
				readLengthThisTime = is.read(message, readLen, contentLen - readLen);
				if (readLengthThisTime == -1) {// Should not happen.
					break;
				}
				readLen += readLengthThisTime;
			}
			return message;

	   }
	
	return new byte[] {};
	}


	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = arg0;
		
	}
	

}