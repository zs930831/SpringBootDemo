package com.zs.girl.Pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * @Author: CHOSEN1
 * @Description:
 * @Date:Created in 15:24 2017/11/7
 * @Modified By:
 */
@Entity
public class Girl {
    @Id
    @GeneratedValue
    private Integer id;
    private String cupSize;
    @Min(value = 18,message = "You should be 18 to come on in!")
    private Integer age;
    //必须要有无参构造器，不然会报错。
    public Girl() {
    }

    public Girl( Integer age,String cupSize) {
        this.cupSize = cupSize;
        this.age = age;
    }

    public Girl(Integer id, Integer age) {
        this.id=id;
        this.cupSize = cupSize;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}