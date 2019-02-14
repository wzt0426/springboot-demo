package com.micky.demo.handler;

import com.micky.demo.utils.Result;
import com.micky.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandel {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandel.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Result handle(Exception e) {
        if (e instanceof  AreaException) {
            AreaException areaException = (AreaException) e;
            LOG.error(e.getLocalizedMessage());
            return ResultUtil.error(areaException.getCode(),areaException.getMessage());
        } else {
            LOG.error("---");
            return ResultUtil.error(-1,"未知错误");
        }

    }
}
