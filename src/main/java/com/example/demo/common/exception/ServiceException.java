package com.haier.zjapplet.common.exception;


/**
 * @Classname ServiceException
 * @Description 服务层异常
 * @Date 2020/12/29 11:00
 * @Created by lichunle
 */
public class ServiceException extends Exception {

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 3990081809637383833L;
  
  /**
   * 错误码
   */
  private String code;
  
  
  /**
   * 参数
   */
  private Object[] parameter;
  
  
  
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Object[] getParameter() {
    return parameter;
  }

  public void setParameter(Object[] parameter) {
    this.parameter = parameter;
  }

  public ServiceException() {
    super();
  }

  public ServiceException(Exception e) {
    super(e);
  }

  public ServiceException(String code, String message) {
    super(message);
    this.code = code;
  }

  public ServiceException(String code) {
    this.code = code;
  }

  public ServiceException(String code, Object[] parameter) {
    this.code = code;
    this.parameter = parameter;
  }
  
  public ServiceException(String code, Object[] parameter, Exception e) {
    super(e);
    this.code = code;
    this.parameter = parameter;
  }

  public ServiceException(String code, String message, Exception e) {
    super(message, e);
    this.code = code;
  }
  
  

}
