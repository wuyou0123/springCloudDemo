package com.txconsume.controller;


import com.common.TestUser;
import com.common.utils.rabbitMqutils.MsgProducer;
import com.common.utils.rabbitMqutils.MsgReceiver;
import com.txconsume.service.TestService;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/insertAll",method = {RequestMethod.POST})
    public Map<String, Object> insertAll(@RequestBody TestUser testUser){
        Map<String,Object> map = new HashMap<>();
            try {
                    String aa=testService.insertAll(testUser);
                    msg="成功";
                    code=1;
                    map.put("msg",msg);
                    map.put("aa",aa);
            }catch (Exception e){
                    msg="失败";
                    code=0;
                    e.printStackTrace();
                    map.put("msg",msg);
                    map.put("code",code);
            }
        return map;
    }


    @Resource
    private MsgProducer msgProducer;
    /**
     * RabbitMQ测试
     */
    @RequestMapping(value = "/testRabbit",method = {RequestMethod.GET})
    public void sendMsgs(){
        for(int i =0;i<3;i++){
            String Rab= "测试rabiitMa"+i;
            msgProducer.sendMsg(Rab);
        }

    }

    @Resource
    private MsgReceiver msgReceiver;
    @RequestMapping(value = "/testgetRabbit",method = {RequestMethod.GET})
    public void receiverMsgs(){
        String Rab= "测试rabiitMas";
        msgReceiver.process(Rab);
    }
}
