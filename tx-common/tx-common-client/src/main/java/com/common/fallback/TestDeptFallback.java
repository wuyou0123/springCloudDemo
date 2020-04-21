package com.common.fallback;

import com.common.Dept;
import com.common.client.deptClient.DeptClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class TestDeptFallback implements DeptClient {
    @Override
    public List<Dept> getDeptList(@RequestBody List<Integer> userIdList) throws Exception {
        return null;
    }
}
