package cn.my.demo.pool.factory;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;

public class UserFactory extends BasePooledObjectFactory {

    public Object create() throws Exception {
        return null;
    }

    public PooledObject wrap(Object o) {
        return null;
    }
}
