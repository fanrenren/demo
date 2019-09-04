package cn.my.demo.pool.service;

import cn.my.demo.model.User;
import cn.my.demo.pool.UserPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author wxh
 * @date 2019/9/4
 */
@Order(Integer.MAX_VALUE)
@Service
public class PoolService {
    @Autowired
    UserPool pool;

    public void getUser(){
        User user= null;
        try {
            user = pool.borrowObject();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(user!=null){
                pool.returnObject(user);
            }
        }
    }
}
