package com.common.fallback;

import com.codingapi.txlcn.tc.support.DTXUserControls;
import com.codingapi.txlcn.tracing.TracingContext;
import com.common.TestUser;
import com.common.client.userClient.UserClient;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TestUserFallback implements UserClient {
    @Override
    public Map<String, Object> getAll() throws Exception {
        return null;
    }

    @Override
    public void insertAll(TestUser testUser) throws Exception {
        DTXUserControls.rollbackGroup(TracingContext.tracing().groupId());
    }
}
