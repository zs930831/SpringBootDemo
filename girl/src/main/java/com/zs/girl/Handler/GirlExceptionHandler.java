package com.zs.girl.Handler;

import com.zs.girl.Dto.GirlResult;
import com.zs.girl.Dto.Utils.GirlResultUtils;
import com.zs.girl.Enum.GirlEnum;
import com.zs.girl.Exceptions.GirlException;
import com.zs.girl.Pojo.Girl;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: CHOSEN1
 * @Description:
 * @Date:Created in 23:00 2017/11/7
 * @Modified By:
 */
@RestControllerAdvice//处理Exception
public class GirlExceptionHandler{

    @ExceptionHandler(value =Exception.class)
    public GirlResult handler(Exception e){
        if ( e instanceof GirlException ){
            GirlException ge=(GirlException) e;
            return GirlResultUtils.error(ge.getCode(),ge.getMessage());
        }else{
            return GirlResultUtils.error(GirlEnum.UKNOWN_ERROR);
        }
    }
}
