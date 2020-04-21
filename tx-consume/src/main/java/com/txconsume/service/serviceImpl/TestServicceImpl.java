package com.txconsume.service.serviceImpl;

import com.common.client.userClient.UserClient;
import com.txconsume.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class TestServicceImpl implements TestService {

    @Resource
    private UserClient userClient;

    @Override
    public Map<String, Object> getAll() throws Exception {
        return userClient.getAll();
    }
}
