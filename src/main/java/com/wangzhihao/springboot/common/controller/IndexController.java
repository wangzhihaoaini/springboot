package com.wangzhihao.springboot.common.controller;

import com.alibaba.fastjson.JSON;
import com.wangzhihao.springboot.common.util.HttpClientUtil;
import com.wangzhihao.springboot.common.util.JsonUtil;
import com.wangzhihao.springboot.system.snowflake.SnowFlakeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author wangzhihao
 * @Date 2019/12/27 16:11
 * @Version 1.0
 **/
@Controller
public class IndexController {
    @Autowired
    private HttpClientUtil httpClientUtil;
    @Autowired
    private JsonUtil jsonUtil;
    @Autowired
    private SnowFlakeFactory snowFlakeFactory;

    /**
    *@Author wangzhihao
    *@Description 输入网址时重定向到博客首页
    *@Date 16:13 2019/12/27
    *@Param []
    *@return java.lang.String
    **/
    @GetMapping("/")
    public String toBlogMain(){
        return  "redirect:/blog/main";
    }

    @GetMapping("/sendHttpRequest")
    @ResponseBody
    public Object sendHttpRequest(HttpServletRequest request){
//        String url="http://localhost:80/http/get";
//        Map<String,String> requestHeadMap=new HashMap<String,String>();
//        Map<String,String> map=new HashMap<>();
//        map.put("version","1.0");
//        map.put("tradeNo","trsnafer");
//        map.put("unionTradeSerialNo","U2020122900000000000000000000001");
//        map.put("tradeSerialNo","20201229000000000000000000000001");
//        map.put("channelId","61");
//        String s1 = JSON.toJSONString(map);
//        requestHeadMap.put("requestHead",s1);
//        requestHeadMap.put("mobilePhone","13888888888");
//        String response = httpClientUtil.doPost(url, requestHeadMap, "UTF-8");
//        Map<String,Object> responseMap = jsonUtil.stringToMap(response);
//        Map<String, Object> responseHead = jsonUtil.stringToMap((String) responseMap.get("responseHead"));
//        System.out.println(responseHead.get("tradeNo"));
        return snowFlakeFactory.nextId();
    }
}
