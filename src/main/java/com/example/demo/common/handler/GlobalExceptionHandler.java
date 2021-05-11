package com.example.demo.common.handler;

import com.example.demo.common.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname GlobalExceptionHandler
 * @Description
 * @Date 2021/4/8 14:12
 * @Created by lichunle
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public String handleException(HttpServletRequest request, ServiceException e) {
        logger.info("错误码:{}", e.getCode());
        return "test exception....";
    }
}
