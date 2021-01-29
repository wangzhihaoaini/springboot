package com.wangzhihao.springboot.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName JsonUtil
 * @Description JSON操作工具类
 * @Author wangzhihao
 * @Date 21/1/15 0015 10:26
 * @Version 1.0
 **/
@Component
public class JsonUtil {
    /**
    *@Author wangzhihao
    *@Description Map转换为String
    *@Date 10:29 21/1/15
    *@Param [map]
    *@return java.lang.String
    **/
    public String mapToString(Map<StringUtil,Object> map){
        return JSON.toJSONString(map);
    }

    /**
    *@Author wangzhihao
    *@Description Json对象转Map
    *@Date 10:31 21/1/15
    *@Param [jsonObject]
    *@return java.util.Map<java.lang.String,java.lang.Object>
    **/
    public Map<String,Object> jsonObjToMap(JSONObject jsonObject){
        return (Map<String,Object>)jsonObject;
    }

    /**
    *@Author wangzhihao
    *@Description json字符串转Map
    *@Date 10:36 21/1/15
    *@Param [jsonString]
    *@return java.util.Map<java.lang.String,java.lang.Object>
    **/
    public Map<String,Object> stringToMap(String jsonString){
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        return (Map<String,Object>)jsonObject;
    }
}
