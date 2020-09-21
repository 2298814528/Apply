package com.group9.apply.util;

import lombok.Data;

/**
 * @ Author     ：张发兴
 * @ Date       ：Created in 16:43 2020/9/21
 * @ Description：
 */
@Data
public class PageResult extends Result{
    long count;


    public PageResult(int code, String msg, Object data, long count) {
        super(code, msg, data);
        this.count = count;
    }
}
