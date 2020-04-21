package com.common.client.deptClient;

import com.common.Dept;
import com.common.config.TestConfig;
import com.common.fallback.TestDeptFallback;
import com.common.server.ServerConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/***
 * 开启feignz注解
 */
@FeignClient(path = ServerConstant.BASIC_PATH,name = ServerConstant.BASIC_SERVER,
             fallback = TestDeptFallback.class,configuration = TestConfig.class)
@Component
public interface DeptClient {

    @RequestMapping(value = "/getDeptList",method = {RequestMethod.POST})
    public List<Dept> getDeptList(@RequestBody List<Integer> userIdList)throws Exception;
}
