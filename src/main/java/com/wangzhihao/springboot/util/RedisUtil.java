package com.wangzhihao.springboot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Autowired
    private static RedisTemplate<String,Object> redisTemplate;

    // =============================common============================
    /**
     * 指定缓存失效时间
     * @param key 键
     * @param time 时间(秒)
     * @return boolean
     */
    public static boolean expire(String key,long time){
        try {
            if(time>0){
                redisTemplate.expire(key,time,TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key 获取过期时间
     * @param key 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public static Long getExpire(String key){
        try {
            return redisTemplate.getExpire(key);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 判断key是否存在
     * @param key 键
     * @return boolean
     */
    public static boolean hasKey(String key){
        try {
            if(key!=null){
                return redisTemplate.hasKey(key);
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

    /**
     * 删除缓存
     * @param keys 可变参数
     */
    @SuppressWarnings("unchecked")
    public void del(String... keys){
        if(keys!=null){
            if(keys.length>0){
                if (keys.length==1){
                    redisTemplate.delete(keys[0]);
                }else{
                    redisTemplate.delete(CollectionUtils.arrayToList(keys));
                }
            }
        }
    }


    // ============================String=============================

    /**
     * 普通缓存获取
     * @param key 键
     * @return Object
     */
    public Object get(String key){
        return key==null?null:redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     * @param key 键
     * @param value 值
     * @return boolean
     */
    public boolean set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存放入并设置时间
     * @param key 键
     * @param value 值
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return boolean
     */
    public boolean set(String key,Object value,long time){
        try {
            if(time>0){
                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
            }else{
                redisTemplate.opsForValue().set(key,value);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 递增
     * @param key 键
     * @param delta 要增加的数值(大于0)
     * @return Long
     */
    public Long incr(String key,long delta){
        if(delta>0&&key!=null){
            return redisTemplate.opsForValue().increment(key,delta);
        }
        return null;
    }

    /**
     * 递减
     * @param key 键
     * @param delta delta 要增加的数值(大于0)
     * @return Long
     */
    public Long decr(String key,long delta){
        if(delta>0&&key!=null){
            return redisTemplate.opsForValue().increment(key,-delta);
        }
        return null;
    }


    // ================================Map=================================


}
