package com.zs.girl.Service;

import com.zs.girl.Dto.GirlResult;
import com.zs.girl.Pojo.Girl;

import java.util.List;

/**
 * @Author: CHOSEN1
 * @Description:
 * @Date:Created in 15:36 2017/11/7
 * @Modified By:
 */
public interface GirlService {
    List<Girl> getGirlList();
    Girl createOneGirl(Integer age,String cupSize);
    Girl getOneGirl(Integer id);
    Girl updateOneGirl(Integer id,Integer age, String cupSize);
    void deleteOneGirl(Integer id);
    Girl getGirlByAge(Integer age);
    GirlResult<Girl> getAge(Integer id) throws Exception;
}
