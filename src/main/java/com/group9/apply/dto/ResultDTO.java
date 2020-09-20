package com.group9.apply.dto;

/**
 * 传输数据
 */
public class ResultDTO {

    /**
     *状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private  String msg;

    /**
     * 具体传递的数据
     */
    private Object data;

    public ResultDTO() {
    }

    public ResultDTO(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultDTO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
