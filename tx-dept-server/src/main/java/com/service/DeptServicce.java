package com.service;

import com.common.Dept;

import java.util.List;

public interface DeptServicce {

   public List<Dept> getDeptList(List<Integer> userIdList) throws Exception;

    public String insertOne(Dept dept) throws Exception;
}
