package com.common;

import lombok.Data;

import java.io.Serializable;

@Data
//实现流的序列化
public class TestUser implements Serializable {

    private  Integer id;

    private  String userName;

    private  Integer age;

    private  String identityCard;

    private  String phone;
}
