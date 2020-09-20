package com.group9.apply.util;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ Author     ：张发兴
 * @ Date       ：Created in 8:55 2020/9/20
 * @ Description：返回结果实体类
 */
@Data
@AllArgsConstructor
public class Result {
    private int code;
    private String msg;
    private Object data;

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
