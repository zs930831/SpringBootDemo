package com.zs.girl.Enum;

/**
 * @Author: CHOSEN1
 * @Description:
 * @Date:Created in 19:20 2017/11/7
 * @Modified By:
 */
public enum GirlEnum {
    UKNOWN_ERROR(-1,"Unkown Error"),
    UNDER_13(100,"Age Under 18"),
    BETWEEN13_16(101,"Age Between 13 And 16"),
    SUCCESS(200,"Come On In");
    private Integer state;
    private String stateInfo;

    GirlEnum(Integer state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }
    public GirlEnum getGirlEnum(int state){
        for (GirlEnum ge:values()
             ) {
            if ( ge.getState()==state ){
                return ge;
            }
        }
        return null;
    }
    public Integer getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

}
