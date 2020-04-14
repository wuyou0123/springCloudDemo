package com.txconsume.controller;


import com.txconsume.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/test")
public class TestController extends  BaseController {

    private  String msg ;

    private  int code ;

    @Resource

    private TestService testService;

    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
    public Map<String,Object> getAll(){
        Map<String,Object> map = new HashMap<>();
        try {
                map=testService.getAll();
                msg="成功";
                code=1;
                map.put("msg",msg);
            }catch (Exception e){
                    msg="失败";
                    code=0;
                    e.printStackTrace();
                    map.put("msg",msg);
                    map.put("code",code);
            }
        return map;
    }
}
