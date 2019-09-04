package cn.my.demo.pool.controller;

import cn.my.demo.pool.service.PoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxh
 * @date 2019/9/4
 */
@Order(10000)
@RestController
@RequestMapping("/pool")
public class PoolController {
    @Autowired
    PoolService poolService;

    @GetMapping
    public String getUser(){
        poolService.getUser();
        return "hello";
    }

}
