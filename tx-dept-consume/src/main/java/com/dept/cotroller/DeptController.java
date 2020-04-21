package com.dept.cotroller;


import com.common.Dept;
import com.dept.service.DeptServicce;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/dept")
public class DeptController extends BaseController{

    @Resource
    private DeptServicce deptServicce;

    @RequestMapping(value = "/getDeptList",method = {RequestMethod.GET})
    public List<Dept> getDeptList()throws Exception{
        return  deptServicce.getDeptList();
    }
}
