/*
 * Copyright (c) 2015-2025 by HRT All rights reserved
 */
package com.example.demo.interceptor;

import java.lang.reflect.Method;

/**
 * @description CurrentRestMethod
 * @author <a href="mailto:wengyongyi@crc.com.hk">wengyongyi</a>
 * @since 2016年12月14日
 * @version 1.0.0
 */
public abstract class CurrentRestMethod {

	private static final ThreadLocal<Class<?>> currentRestClz = new ThreadLocal<>();
	private static final ThreadLocal<Method> currentRestName = new ThreadLocal<>();
	private static final ThreadLocal<Long> startTime = new ThreadLocal<>();

	public static void setRestClz(Class<?> clz) {
		if (null != clz) {
			currentRestClz.set(clz);
		} else {
			currentRestClz.remove();
		}
	}

	public static void setRestMethod(Method method) {
		if (null != method) {
			currentRestName.set(method);
		} else {
			currentRestName.remove();
		}
	}

	public static void setStartTime(Long stTime) {
		if (null != stTime) {
			startTime.set(stTime);
		} else {
			startTime.remove();
		}
	}

	public static Class<?> getRestClz() {
		return currentRestClz.get();
	}

	public static Method getRestMethod() {
		return currentRestName.get();
	}

	public static Long getStartTime() {
		return startTime.get();
	}

	public static void clear() {
		currentRestClz.remove();
		currentRestName.remove();
		startTime.remove();
	}
}
