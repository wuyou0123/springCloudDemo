package com.service.Impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.common.Dept;
import com.common.dao.DeptMapper;
import com.service.DeptServicce;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DeptServiceImpl implements DeptServicce {
    @Resource
    private DeptMapper deptMapper;

    @Override
    public List<Dept> getDeptList(List<Integer> userIdList) throws Exception {
        Map<String,List<Integer>> map = new HashMap<>();
        map.put("userIdList",userIdList);
        return deptMapper.getDeptList(map);
    }

    /***
     * tx-lcn 测试分布式事务（参与方）
     * @param dept
     * @throws Exception
     */
    @Override
    @Transactional
    @LcnTransaction
    public String insertOne(Dept dept) throws Exception {
          deptMapper.insertOne(dept);
          return "ok-service-b";

    }
}
