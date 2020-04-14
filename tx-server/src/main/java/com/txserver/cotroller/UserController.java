package com.txserver.cotroller;

import com.txserver.service.UserServicce;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping(value = "/test")
public class UserController {

    private String msg="成功";

    private int code =1;

    @Resource
    private UserServicce userServicce;

    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
    public Map<String,Object> getAll()throws Exception{
        Map<String,Object> map = null;
        map=userServicce.getAll();
        map.put("msg",msg);
        map.put("code",code);
        return  map;
    }

}
