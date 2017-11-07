package com.zs.girl.Controller;

import com.zs.girl.Dto.GirlResult;
import com.zs.girl.Dto.Utils.GirlResultUtils;
import com.zs.girl.Enum.GirlEnum;
import com.zs.girl.Pojo.Girl;
import com.zs.girl.Service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: CHOSEN1
 * @Description:
 * @Date:Created in 15:39 2017/11/7
 * @Modified By:
 */
@RestController
@RequestMapping("/girls")
public class GirlController {
    @Autowired
    private GirlService girlService;

    @GetMapping("")
    public List<Girl> getGirlList(){
        List<Girl> list = girlService.getGirlList();
        return list;
    }

    @PostMapping("")
    public GirlResult<Girl> createGirl(@Valid Girl girl, BindingResult bindingResult){
        if ( bindingResult.hasErrors() ){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return GirlResultUtils.error(GirlEnum.UKNOWN_ERROR);
        }
        Girl oneGirl = girlService.createOneGirl(girl.getAge(), girl.getCupSize());
        return GirlResultUtils.success(GirlEnum.SUCCESS,oneGirl);
    }

    @GetMapping("/id/{id}")
    public Girl getOneGirl(@PathVariable(value = "id")Integer id){
        Girl oneGirl = girlService.getOneGirl(id);
        return oneGirl;
    }

    @PutMapping("/id/{id}")
    public Girl updateOneGirl(@PathVariable(value = "id")Integer id,
                              @RequestParam(value = "age")Integer age,
                              @RequestParam(value = "cupSize")String cupSize){
        Girl girl = girlService.updateOneGirl(id,age, cupSize);
        return girl;
    }

    @DeleteMapping("/id/{id}")
    public void deleteOneGirl(@PathVariable(value = "id")Integer id){
        girlService.deleteOneGirl(id);
    }

    @GetMapping("/age/{age}")
    public Girl getOneGirlByAge(@PathVariable("age") Integer age){
        Girl girlByAge = girlService.getGirlByAge(age);
        return girlByAge;
    }
    @GetMapping(value = "/getAge/{id}")
    public GirlResult<Girl> getAge(@PathVariable("id") Integer id) throws Exception{
        GirlResult<Girl> result = girlService.getAge(id);
        return result;
    }
}
