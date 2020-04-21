package com.cotroller;

import com.common.Dept;
import com.service.DeptServicce;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/dept")
public class DeptController{

    @Resource
    private DeptServicce deptServicce;

    @RequestMapping(value = "/getDeptList",method = {RequestMethod.POST})
    public List<Dept> getDeptList(@RequestBody List<Integer> userIdList)throws Exception{
        List<Dept> deptList=deptServicce.getDeptList(userIdList);
        return  deptList;
    }
}
