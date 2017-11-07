package com.zs.girl.Respository;

import com.zs.girl.Pojo.Girl;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @Author: CHOSEN1
 * @Description:相当于Mybatis里面的单表Mapper
 * @Date:Created in 15:47 2017/11/7
 * @Modified By:
 */
public interface GirlRespository extends JpaRepository<Girl,Integer>{
    Girl findByAge(Integer age);
}
