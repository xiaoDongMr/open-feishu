package com.ruoyi.bitable.config;

import com.lark.oapi.core.cache.ICache;
import com.ruoyi.common.core.redis.RedisCache;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisStore implements ICache {
    @Autowired
    private RedisCache redisCache;

    @Override
    public String get(String s) {
        return redisCache.getCacheObject(s);
    }

    @Override
    public void set(String s, String s1, int i, TimeUnit timeUnit) {
        redisCache.setCacheObject(s, s1, i, timeUnit);
    }

}
