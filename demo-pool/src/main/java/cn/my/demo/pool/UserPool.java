package cn.my.demo.pool;

import cn.my.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

@Slf4j
public class UserPool extends GenericObjectPool<User> {

    public UserPool(PooledObjectFactory<User> factory) {
        super(factory);
        log.info("zzzz");
    }

    public UserPool(PooledObjectFactory<User> factory, GenericObjectPoolConfig<User> config) {
        super(factory, config);
    }

    public UserPool(PooledObjectFactory<User> factory, GenericObjectPoolConfig<User> config, AbandonedConfig abandonedConfig) {
        super(factory, config, abandonedConfig);
    }
}
