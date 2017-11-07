package com.zs.girl.Exceptions;


import com.zs.girl.Enum.GirlEnum;

/**
 * @Author: CHOSEN1
 * @Description:
 * @Date:Created in 23:00 2017/11/7
 * @Modified By:
 */

public class GirlException extends RuntimeException {
    private Integer code;
    public GirlException(GirlEnum girlEnum) {
        super(girlEnum.getStateInfo());
        this.code=girlEnum.getState();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
