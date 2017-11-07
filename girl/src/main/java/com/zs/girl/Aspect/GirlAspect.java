package com.zs.girl.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: CHOSEN1
 * @Description:配置切面。
 * @Date:Created in 19:53 2017/11/7
 * @Modified By:
 */
@Component
@Aspect
public class GirlAspect {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    /**
     *@Author:ZhangShuai
     *@Description:切点。
     *@Date: 20:11 2017/11/7
     *@Modify Info:
     */
    @Pointcut("execution(public * com.zs.girl.Controller.GirlController.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("====================Logger Begin==================");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+
                    joinPoint.getSignature().getName());
        //参数
        logger.info("params={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("====================Logger End==================");
    }
//    @AfterReturning(returning = "object",pointcut = "log()")
//    public void doAfterReturning(Object object){
//        if ( null==object ){
//            logger.info("return=null");
//        }else {
//            logger.info("return={}",object.toString());
//        }
//    }
}
