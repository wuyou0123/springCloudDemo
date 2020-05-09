package com.txserver.service.Impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.common.TestUser;
import com.common.dao.TestUserMapper;
import com.txserver.service.UserServicce;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServieImpl  implements UserServicce {

    @Resource
    private TestUserMapper userMapper;

    @Override
    public Map<String, Object> getAll() throws Exception {
        Map<String, Object> map =new HashMap<>();
        List<TestUser> list =userMapper.getAll();
        map.put("list",list);
        return map;
    }

    @Override
    @Transactional
    @LcnTransaction
    public void insertAll(TestUser testUser) throws Exception {
         userMapper.insertAll(testUser);
        System.out.println("是否插入");
    }
}
