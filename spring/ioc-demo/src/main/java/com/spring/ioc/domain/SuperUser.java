package com.spring.ioc.domain;

import com.spring.ioc.annotation.Super;

/**
 * @author ：kelvin
 * @date ：2021/7/11
 * @description ：
 */
@Super
public class SuperUser extends User{

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
