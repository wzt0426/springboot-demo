package com.micky.demo.handler;

import com.micky.demo.enums.ResultEnum;

public class AreaException extends RuntimeException {
    private Integer code;

    public AreaException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
