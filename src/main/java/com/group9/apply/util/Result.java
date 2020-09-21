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

    public Result() {
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
