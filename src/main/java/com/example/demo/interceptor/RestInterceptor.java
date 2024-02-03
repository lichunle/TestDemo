/*
 * Copyright (c) 2015-2025 by HRT All rights reserved
 */
package com.example.demo.interceptor;

//import com.crt.wallet.infra.common.context.ContextParamManager;
//import com.crt.wallet.infra.common.context.TransactionUuidManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * RestInterceptor
 * 
 * @author <a href="mailto:wengyongyi@crc.com.hk">wengyongyi</a>
 * @since 2017年7月29日
 * @version 1.0.0
 */
public class RestInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LogManager.getLogger(RestInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTimeMs = System.currentTimeMillis();
		// 用于区分mvc:resources, 正常的Controller请求
		if (handler == null || !HandlerMethod.class.isAssignableFrom(handler.getClass())) {
			return true;
		}

		HandlerMethod hm = (HandlerMethod) handler;
		CurrentRestMethod.setRestClz(hm.getBeanType());
		CurrentRestMethod.setRestMethod(hm.getMethod());
		CurrentRestMethod.setStartTime(startTimeMs);

		logger.info("REST {}.{} start.", hm.getBeanType().getName(), hm.getMethod().getName());

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		try {
			Class<?> restClz = CurrentRestMethod.getRestClz();
			Method restMethod = CurrentRestMethod.getRestMethod();
			Long beginTimeMs = CurrentRestMethod.getStartTime();
			if (null != restClz && null != restMethod) {
				if (null != beginTimeMs) {
					long elapsedTimeMs = System.currentTimeMillis() - beginTimeMs.longValue();
					logger.info("REST {}.{} End. Elapsed Time: {}ms.", restClz.getName(), restMethod.getName(),
							elapsedTimeMs);
				} else {
					logger.info("REST {}.{} End.", restClz.getName(), restMethod.getName());
				}
			}
		} finally {
			CurrentRestMethod.clear();
//			TransactionUuidManager.clear();
//			ContextParamManager.clear();

			// 清理log4j2线程变量
//			FinRestCRTMDCExtents.reset();
		}
	}

}
