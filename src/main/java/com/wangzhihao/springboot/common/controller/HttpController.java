package com.wangzhihao.springboot.common.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HttpController
 * @Description TODO
 * @Author wangzhihao
 * @Date 21/1/8 0008 09:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/http")
public class HttpController {

    @PostMapping("/get")
    public Map<String, String> get(HttpServletRequest request){
        System.out.println(request.getHeader("requestHead"));
        System.out.println(request.getHeader("mobilePhone"));
        Map<String,String> responseHeadMap=new HashMap<String,String>();
        Map<String,String> map=new HashMap<>();
        map.put("version","1.0");
        map.put("tradeNo","trsnafer");
        map.put("unionTradeSerialNo","U2020122900000000000000000000001");
        map.put("tradeSerialNo","20201229000000000000000000000001");
        map.put("channelId","61");
        String s = JSON.toJSONString(map);
        responseHeadMap.put("responseHead",s);
        responseHeadMap.put("cifNo","000001");
        return responseHeadMap;
    }
}
