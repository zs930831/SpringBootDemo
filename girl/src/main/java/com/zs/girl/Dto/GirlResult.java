package com.zs.girl.Dto;

import com.zs.girl.Enum.GirlEnum;

/**
 * @Author: CHOSEN1
 * @Description:
 * @Date:Created in 19:14 2017/11/7
 * @Modified By:
 */
public class GirlResult<T> {
    private Integer code;
    private T data;
     private String message;
    //成功
    public GirlResult(GirlEnum girlEnum,T data) {
        this.code = girlEnum.getState();
        this.data = data;
        this.message = girlEnum.getStateInfo();
    }

    public GirlResult(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    //失败
    public GirlResult(GirlEnum girlEnum) {
        this.code = girlEnum.getState();
        this.message = girlEnum.getStateInfo();
    }

    public GirlResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}