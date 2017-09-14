package com.hisun.base.log;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 
 *<p>类名称：LoggingAspect</p>
 *<p>类描述: </p>
 *<p>公司：湖南海数互联信息技术有限公司</p>
 *@创建人：Rocky
 *@创建时间：2014-12-9 下午2:57:11
 *@创建人联系方式：24212477@qq.com
 *@version
 */
@Aspect
@Component
public class LoggingAspect {

	private final Logger logger = Logger.getLogger(getClass());
	
	//需要与日志管理模块进行整合，调用日志管理服务记录日志。
	
	
	//所有Controller所有方法的切入点
	@Pointcut("execution(* net.wish30.cloud.*.controller.*.*(..))")
    public void controllerAnyMethod(){}
	//所有Service中save开头的方法的切入点
	//@Pointcut("execution(* net.wish30..service.*.save*(..))")
    //public void serviceSaveMethod(){}
	//所有Service中update开头的方法的切入点
	//@Pointcut("execution(* net.wish30..service.*.update*(..))")
    //public void serviceUpdateMethod(){}
	//所有Service中delete开头的方法的切入点
	//@Pointcut("execution(* net.wish30..service.*.delete*(..))")
    //public void serviceDeleteMethod(){}
	//所有Service中所有方法的切入点
	@Pointcut("execution(* net.wish30..service.*.*(..))")
    public void serviceAnyMethod(){}
	
	@Before("controllerAnyMethod()")
	public void beforeControllerAnyMethodCall(JoinPoint jp){
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		String msg = "Invoke Controller method:"+methodName+",parameters:"+Arrays.toString(args);
		if(logger.isDebugEnabled()){
			logger.info(msg);
		}
	}
	@AfterThrowing(pointcut="controllerAnyMethod()",throwing="ex")
	public void afterControllerAnyMethodThrowingCall(JoinPoint jp,Exception ex){
		String methodName = jp.getSignature().getName();
		logger.error(methodName, ex);
	}
	
	/*@Before("serviceSaveMethod()")
	public void beforeServiceSaveCall(JoinPoint jp){
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		String msg = "Invoke save method:"+methodName+",parameters:"+Arrays.toString(args);
		if(logger.isDebugEnabled()){
			logger.info(msg);
		}
	}
	@AfterThrowing(pointcut="serviceSaveMethod()",throwing="ex")
	public void afterServiceSaveThrowingCall(JoinPoint jp,Exception ex){
		String methodName = jp.getSignature().getName();
		if(logger.isDebugEnabled()){
			logger.error(methodName, ex);
		}
	}

	@Before("serviceDeleteMethod()")
	public void beforeServiceDeleteCall(JoinPoint jp){
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		String msg = "Invoke delete method:"+methodName+",parameters:"+Arrays.toString(args);
		if(logger.isDebugEnabled()){
			logger.info(msg);
		}
	}
	
	@AfterThrowing(pointcut="serviceDeleteMethod()",throwing="ex")
	public void afterServiceDeleteThrowingCall(JoinPoint jp,Exception ex){
		String methodName = jp.getSignature().getName();
		if(logger.isDebugEnabled()){
			logger.error(methodName, ex);
		}
	}
	
	@Before("serviceUpdateMethod()")
	public void beforeServiceUpdateCall(JoinPoint jp,Exception ex){
		String methodName = jp.getSignature().getName();
		if(logger.isDebugEnabled()){
			logger.error(methodName, ex);
		}
	}
	
	@AfterThrowing(pointcut="serviceUpdateMethod()",throwing="ex")
	public void afterServiceUpdateThrowingCall(JoinPoint jp,Exception ex){
		String methodName = jp.getSignature().getName();
		if(logger.isDebugEnabled()){
			logger.error(methodName, ex);
		}
	}*/

	
	@Before("serviceAnyMethod()")
	public void beforeServiceAnyMethodCall(JoinPoint jp){
		String className = jp.getTarget().getClass().getName();
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		String msg = "Invoke "+className+"."+methodName+"(..),parameters:"+Arrays.toString(args);
		if(logger.isDebugEnabled()){
			logger.info(msg);
		}
	}
	
	@AfterThrowing(pointcut="serviceAnyMethod()",throwing="ex")
	public void afterServiceAnyMethodThrowingCall(JoinPoint jp,Exception ex){
		String className = jp.getTarget().getClass().getName();
		String methodName = jp.getSignature().getName();
		logger.error(className+"."+methodName+"(..)", ex);
	}
	

}
