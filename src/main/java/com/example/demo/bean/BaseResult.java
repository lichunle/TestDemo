package com.example.demo.bean;

import com.alibaba.fastjson.annotation.JSONType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Locale;

/**
 * @description: 基础返回结果
 * @author: lichunle
 * @create: 2020/12/30
 **/
@JSONType(ignores = {"locale", "parameter"})
public class BaseResult implements Serializable {
    private static final long serialVersionUID = -2828705615783419799L;


    /**
     * 返回码
     */
    private String retCode;

    /**
     * 返回描述信息
     */
    private String retInfo;

    /**
     * 数据体
     */
    private Object data;

    /**
     * Locale
     */
    private Locale locale;

    /**
     * 参数
     */
    private Object[] parameter;

    public BaseResult() {
        this.retCode = "00000";
    }

    public BaseResult(String retCode) {
        this.retCode = retCode;
    }

    public BaseResult(String retCode, Locale locale) {
        this.retCode = retCode;
        this.locale = locale;
    }

    public BaseResult(String retCode, String retInfo) {
        this.retCode = retCode;
        this.retInfo = retInfo;
    }

    public BaseResult(String retCode, String retInfo, Locale locale) {
        this.retCode = retCode;
        this.retInfo = retInfo;
        this.locale = locale;
    }

    public BaseResult(String retCode, String retInfo, Locale locale, Object[] parameter) {
        this.retCode = retCode;
        this.retInfo = retInfo;
        this.locale = locale;
        this.parameter = parameter;
    }


    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }


    public void setRetInfo(String retInfo) {
        this.retInfo = retInfo;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Object[] getParameter() {
        return parameter;
    }

    public void setParameter(Object[] parameter) {
        this.parameter = parameter;
    }
}
