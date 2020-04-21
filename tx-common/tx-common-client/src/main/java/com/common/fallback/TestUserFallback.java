package com.common.fallback;

import com.common.client.userClient.UserClient;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TestUserFallback implements UserClient {
    @Override
    public Map<String, Object> getAll() throws Exception {
        return null;
    }
}
