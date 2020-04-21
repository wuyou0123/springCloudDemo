package com.dept.service.Impl;

import com.common.Dept;
import com.common.client.deptClient.DeptClient;
import com.common.client.userClient.UserClient;
import com.dept.service.DeptServicce;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DeptServiceImpl implements DeptServicce {

    @Resource
    private UserClient userClient;

    @Resource
    private DeptClient deptClient;

    @Override
    public List<Dept> getDeptList() throws Exception {
        Map<String,Object> map=userClient.getAll();
        List<Integer> userIdList= new ArrayList<>();
        List<Map<String, Object>> maps= (List<Map<String, Object>>) map.get("list");
        userIdList.add((Integer) (maps.get(0).get("id")));
        List<Dept> deptList=deptClient.getDeptList(userIdList);
        return deptList;
    }
}
