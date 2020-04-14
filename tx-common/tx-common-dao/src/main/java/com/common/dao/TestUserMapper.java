package com.common.dao;

import com.common.TestUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TestUserMapper {

     public List<TestUser> getAll();
}
