package com.common.client.userClient;

import com.common.TestUser;
import com.common.config.TestConfig;
import com.common.fallback.TestUserFallback;
import com.common.server.ServerConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**添加feignClient注解*/
@FeignClient(name = ServerConstant.USER_SERVER ,configuration = TestConfig.class,
             fallback = TestUserFallback.class ,path = ServerConstant.USER_PATH)
@Component//springIOC交给spring容器管理
public interface UserClient {

    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
    public Map<String,Object> getAll()throws Exception;

    @RequestMapping(value = "/insertAll",method = {RequestMethod.POST})
    public void insertAll(@RequestBody  TestUser testUser)throws Exception;
}
