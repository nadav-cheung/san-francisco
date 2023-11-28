package cn.com.nadav.sanfrancisco.web.controller;

import cn.com.nadav.sanfrancisco.openfeign.rest.IndexClientApi;
import cn.com.nadav.sanfrancisco.web.properties.WebProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ClusterOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.RedisClientInfo;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class IndexController implements IndexClientApi {

    @Autowired
    private WebProperties webProperties;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String index() {
        return webProperties.getWelcomeIndex();
    }

    @Override
    public String redisIndex() {
        ClusterOperations<String, String> stringStringClusterOperations =
                stringRedisTemplate.opsForCluster();
        log.info("stringStringClusterOperations={}", stringStringClusterOperations);


        List<RedisClientInfo> clientList = stringRedisTemplate.getClientList();

        return "OK";
    }

}
