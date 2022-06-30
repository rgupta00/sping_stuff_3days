package com.productapp.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Transactional doing declartive tx mgt=> aop around advice

@Component
@Aspect
public class LoggingAspect {

	// @Aroud, @Before, @After @AfterReturing @ThrowsAdvice (REST exception handing)

	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Pointcut("execution(* com.productapp.service.ProductServiceImpl.getAll(..))")
	public void myPointCut() {
	}

	// if some ex is coming from service layer ... then i should log it into some
	// file

	@AfterThrowing(pointcut = "execution( * com.productapp.service.*Impl.*(..))", throwing = "exception")
	public void logException(Exception exception) {

		logger.error("some error have occured "+ exception.toString());
	}

	// @Around("myPointCut()")
	// @Around("execution( * com.productapp.service.*Impl.*(..))")
	// @Around("execution( List<Product> getAll())") //?

	@Around("@annotation(MyLogger)")
	public Object logging(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis();
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Object result = jp.proceed();

		long end = System.currentTimeMillis();

		logger.info("time taken by getall method is: " + jp.getSignature().getName() + (end - start) + " ms");

		return result;
		// u can get info about target method
	}
}
