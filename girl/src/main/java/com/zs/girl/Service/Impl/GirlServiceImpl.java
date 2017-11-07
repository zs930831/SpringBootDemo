package com.zs.girl.Service.Impl;

import com.zs.girl.Dto.GirlResult;
import com.zs.girl.Enum.GirlEnum;
import com.zs.girl.Exceptions.GirlException;
import com.zs.girl.Pojo.Girl;
import com.zs.girl.Respository.GirlRespository;
import com.zs.girl.Service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: CHOSEN1
 * @Description:
 * @Date:Created in 15:38 2017/11/7
 * @Modified By:
 */
@Service
@EnableTransactionManagement// 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class GirlServiceImpl implements GirlService{
    @Autowired
    private GirlRespository girlRespository;

    @Override
    public List<Girl> getGirlList() {
        List<Girl> list = girlRespository.findAll();
        if ( list!=null && list.size()>0 ){
            return list;
        }
        return null;
    }

    @Override
    public Girl createOneGirl(Integer age, String cupSize) {
        Girl girl = new Girl(age, cupSize);
        Girl savedGirl = girlRespository.save(girl);
        return savedGirl;
    }

    @Override
    public Girl getOneGirl(Integer id) {
        Girl one = girlRespository.findOne(id);
        return one;
    }

    @Override
    @Transactional
    public Girl updateOneGirl(Integer id,Integer age, String cupSize) {
        Girl girl = new Girl(age, cupSize);
        girl.setId(id);
        Girl save = girlRespository.save(girl);
        return save;
    }

    @Override
    @Transactional
    public void deleteOneGirl(Integer id) {
        girlRespository.delete(id);
    }

    @Override
    public Girl getGirlByAge(Integer age) {
        Girl girl = girlRespository.findByAge(age);
        return girl;
    }

    @Override
    public GirlResult<Girl> getAge(Integer id) throws Exception{
        Girl girl = girlRespository.findOne(id);
        Integer age = girl.getAge();
        if ( age<13 ){
            throw new GirlException(GirlEnum.UNDER_13);
        }else if(age>13 && age<16){
            throw new GirlException(GirlEnum.BETWEEN13_16);
        }
        return new GirlResult<Girl>(GirlEnum.SUCCESS,girl);
    }
}
