package com.txconsume.service.serviceImpl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.common.Dept;
import com.common.TestUser;
import com.common.client.deptClient.DeptClient;
import com.common.client.userClient.UserClient;
import com.txconsume.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

@Service
public class TestServicceImpl implements TestService {

    @Resource
    private UserClient userClient;

    @Resource
    private DeptClient deptClient;

    @Override
    public Map<String, Object> getAll() throws Exception {
        return userClient.getAll();
    }

    /***
     * tx-lcn 测试分布式事务（发起方）
     * @param
     * @throws Exception
     */
    @Override
    @LcnTransaction
    public String insertAll(TestUser testUser) throws Exception {
        Dept dept = new Dept();
        dept.setDeptName("市场部");
        dept.setDeptFid(0);
        String dResp =deptClient.insertOne(dept);
        System.out.println("将dept服务抛异常测试回滚");
        userClient.insertAll(testUser);
        System.out.println("测试user服务是否回滚");

        // 置异常标志，DTX 回滚
        if (Objects.nonNull(testUser)) {
            throw new IllegalStateException("by testUser");
        }
        return dResp + " > " + " > " + "ok-service-a";
    }

}
