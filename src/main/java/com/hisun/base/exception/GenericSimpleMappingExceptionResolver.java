package com.hisun.base.exception;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 *<p>类名称：GenericSimpleMappingExceptionResolver</p>
 *<p>类描述: </p>
 *<p>公司：湖南海数互联信息技术有限公司</p>
 *@创建人：Rocky
 *@创建时间：2014-12-8 下午5:34:07
 *@创建人联系方式：24212477@qq.com
 *@version
 */
public class GenericSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver{

	 @Override  
	 protected ModelAndView doResolveException(HttpServletRequest request,  
	            HttpServletResponse response, Object handler, Exception ex) {  
	        // Expose ModelAndView for chosen error view.  
	        String viewName = determineViewName(ex, request);
	        //log exception
	        logException(ex, request);
	        if (viewName != null) {
	        	//返回为JSP视图
	            if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request  
	                    .getHeader("X-Requested-With")!= null && request  
	                    .getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {  
	                // Apply HTTP status code for error views, if specified.  
	                // Only apply it if we're processing a top-level request.  
	                Integer statusCode = determineStatusCode(request, viewName);  
	                if (statusCode != null) {  
	                    applyStatusCodeIfPossible(request, response, statusCode);  
	                }  
	                return getModelAndView(viewName, ex, request);  
	            } else {
	            	//JSON格式
	                try {  
	                	response.setContentType("application/json");
	                    PrintWriter writer = response.getWriter();  
	                    writer.write("{\"success\":\"false\",\"code\":-1,\"message\":\"系统错误\"}");
	                    writer.flush();  
	                } catch (IOException e) {  
						logger.error(e,e);
	                }  
	                return null;  
	  
	            }  
	        } else {  
	            return null;  
	        }  
	    } 
}
