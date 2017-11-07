package com.zs.girl.Controller;

import com.zs.girl.Properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: CHOSEN1
 * @Description:
 * @Date:Created in 12:53 2017/11/7
 * @Modified By:
 */
@RestController
@PropertySource(value = "classpath:application-product.yml")
public class HelloController {
//    @Value("${cupSize}")
//    private String cupsize;
//    @Value("${age}")
//    private Integer age;
    @Autowired
    private GirlProperties girlProperties;
    @Value("${content}")
    private String content;
    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    public String HelloWorld(){
        String cupsize=girlProperties.getCupSize();
        Integer age=girlProperties.getAge();
        return cupsize+"========"+age+"============="+content;
    }

}
