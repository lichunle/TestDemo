package com.example.demo.common.handler;

import com.example.demo.common.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Classname GlobalExceptionHandler
 * @Description
 * @Date 2021/4/8 14:12
 * @Created by lichunle
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
                                                        HttpServletRequest request) {
        logger.error("=====请求参数校验错误 " + request.getRequestURI() + ":" + ex.getMessage(),
                ex);
        List<ObjectError> list = ex.getBindingResult().getAllErrors();
        StringBuilder sb = new StringBuilder();
        for (ObjectError objectError : list) {
            sb.append(((FieldError) objectError).getField()).append(objectError.getDefaultMessage()).append(",");
        }
        return sb.toString();
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public String handleException(HttpServletRequest request, ServiceException e) {
        logger.info("错误码:{}", e.getCode());
        return "test exception....";
    }
}
