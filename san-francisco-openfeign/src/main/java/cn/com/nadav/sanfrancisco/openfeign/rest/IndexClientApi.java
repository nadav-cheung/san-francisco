package cn.com.nadav.sanfrancisco.openfeign.rest;

import org.springframework.web.bind.annotation.GetMapping;

public interface IndexClientApi {

    @GetMapping("index/redisIndex")
    String redisIndex();

    @GetMapping("index/index")
    String index();
}
