package cn.my.demo.pool.config;

import cn.my.demo.pool.UserPool;
import cn.my.demo.pool.factory.UserFactory2;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import cn.my.demo.pool.properties.PoolProperties;

import javax.annotation.PreDestroy;

/**
 * 对象池配置
 *
 * @author wxh
 * @date 2019/9/4
 */
@EnableConfigurationProperties(PoolProperties.class)
@Configuration
public class PoolAutoConfiguration {

    private  final PoolProperties poolProperties;
    private UserPool pool;

    @Autowired
    public PoolAutoConfiguration(PoolProperties poolProperties){
        this.poolProperties = poolProperties;
    }

    @ConditionalOnClass({UserFactory2.class})
    @Bean
    public UserPool initPool(){
        UserFactory2 userFactory2 = new UserFactory2();
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(poolProperties.getMaxIdle());
        poolConfig.setMinIdle(poolConfig.getMinIdle());
        poolConfig.setMaxTotal(poolConfig.getMaxTotal());
        poolConfig.setBlockWhenExhausted(true);
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(true);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setTimeBetweenEvictionRunsMillis(1000 * 60 * 30);
        //一定要关闭jmx，不然springboot启动会报已经注册了某个jmx的错误
        poolConfig.setJmxEnabled(false);
        //新建一个对象池,传入对象工厂和配置
        pool = new UserPool(userFactory2, poolConfig);
        initPool(poolProperties.getInitialSize(), poolProperties.getMaxIdle());
        return pool;
    }

    /**
     * 预先加载User对象到对象池中
     *
     * @param initialSize 初始化连接数
     * @param maxIdle     最大空闲连接数
     */
    private void initPool(int initialSize,int maxIdle){
        if (initialSize <= 0) {
            return;
        }

        int size = Math.min(initialSize, maxIdle);
        for (int i = 0; i < size; i++) {
            try {
                pool.addObject();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @PreDestroy
    public void destroy() {
        if (pool != null) {
            pool.close();
        }
    }
}
