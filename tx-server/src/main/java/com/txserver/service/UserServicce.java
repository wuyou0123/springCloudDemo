package com.txserver.service;

import com.common.TestUser;

import java.util.Map;

public interface UserServicce {

   public Map<String, Object> getAll()throws Exception;

   public void insertAll(TestUser testUser)throws Exception;
}
