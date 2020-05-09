package com.common.fallback;

import com.codingapi.txlcn.tc.support.DTXUserControls;
import com.codingapi.txlcn.tracing.TracingContext;
import com.common.Dept;
import com.common.client.deptClient.DeptClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class TestDeptFallback implements DeptClient {

    @Override
    public List<Dept> getDeptList(@RequestBody List<Integer> userIdList) throws Exception {
        DTXUserControls.rollbackGroup(TracingContext.tracing().groupId());
        return null;
    }

    @Override
    public String insertOne(Dept dept) throws Exception {
      DTXUserControls.rollbackGroup(TracingContext.tracing().groupId());
        return null;
    }
}
