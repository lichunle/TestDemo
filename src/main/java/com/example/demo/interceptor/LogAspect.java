package com.example.demo.interceptor;



import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Slf4j
@Configuration
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.example.demo.controller..*.*(..))")
    private void controllerAspect() {
    }

    @Before(value = "controllerAspect()")
    public void invokeBefore(JoinPoint point) {
        String traceId = UUID.randomUUID().toString().replace("-", "");
        if (canPrintLog(point)) {
            log.info("Request url: {}, execute method: {},header: {}, requestParams: {}", getRequestUrl(),
                    getMethodName(point), getRequestHeaderInfo(), getRequestParams(point));
        }
    }

    @AfterReturning(pointcut = "controllerAspect()", returning = "returnValue")
    public void invokeAfter(JoinPoint point, Object returnValue) {
        String realClassName = getRealClassName(point);
        if (canPrintLog(point)) {
            log.info("Invoke class: {}, execute method: {}, response:{}", realClassName, getMethodName(point),
                    returnValue);
        }
    }

    private String getRealClassName(JoinPoint point) {
        return point.getTarget().getClass().getName();
    }

    private String getMethodName(JoinPoint point) {
        return point.getSignature().getName();
    }

    private List<Object> getRequestParams(JoinPoint point) {
        List<Object> params = new ArrayList<>();
        Object[] args = point.getArgs();
        for (Object arg : args) {
            params.add(arg);
        }
        return params;
    }

    private boolean canPrintLog(JoinPoint point) {
        List<String> canNotPrintLog = new ArrayList<>();
        if (canNotPrintLog.contains(point.getSignature().getName())) {
            return false;
        }
        return true;
    }

    private Map<String, String> getRequestHeaderInfo() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        Enumeration<String> enumeration = request.getHeaderNames();
        Map<String, String> headerMap = Maps.newHashMap();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            if (!"cookie".equals(name)) {
                headerMap.put(name, request.getHeader(name));
            }
        }
        return headerMap;
    }

    private String getRequestUrl() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        String requestURI = request.getRequestURI();
        return requestURI;
    }
}
