package com.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Dept implements Serializable {

    private  Integer id;

    private  String deptName;

    private  Integer userId;

    private Integer deptFid;
}
