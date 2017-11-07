package com.zs.girl.Dto.Utils;

import com.zs.girl.Dto.GirlResult;
import com.zs.girl.Enum.GirlEnum;

/**
 * @Author: CHOSEN1
 * @Description:
 * @Date:Created in 20:43 2017/11/7
 * @Modified By:
 */
public class GirlResultUtils {
    public static GirlResult success(GirlEnum girlEnum,Object data){
        return new GirlResult(girlEnum,data);
    }
    public static GirlResult success(GirlEnum girlEnum){
        return new GirlResult(girlEnum,null);
    }
    public static GirlResult error(Integer code,String error){
        return new GirlResult(code,error);
    }
    public static GirlResult error(GirlEnum girlEnum){
        return new GirlResult(girlEnum);
    }
}
