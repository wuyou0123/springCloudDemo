package com.common.dao;

import com.common.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface DeptMapper {

    public List<Dept> getDeptList(Map<String,List<Integer>> map);
}
