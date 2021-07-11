package com.spring.ioc.domain;

/**
 * @author ：kelvin
 * @date ：2021/7/6
 * @description ：
 */
public class User {

    private Integer id ;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
