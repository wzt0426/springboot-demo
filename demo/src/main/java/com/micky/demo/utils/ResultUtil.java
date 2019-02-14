package com.micky.demo.utils;

public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("---");
        result.setData(object);
        return result;
    }

    public static Result success() {
            return success(null);
    }

    public static Result error(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(message);
        result.setData(null);
        return result;
    }
}
