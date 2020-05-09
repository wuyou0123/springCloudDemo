package com.txconsume.service;

import com.common.TestUser;

import java.util.Map;

public interface TestService {

   public Map<String, Object> getAll() throws Exception;

   public String insertAll(TestUser testUser) throws Exception;
}
