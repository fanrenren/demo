package cn.my.demo.pool.factory;

import cn.my.demo.model.User;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class UserFactory2 implements PooledObjectFactory<User> {
    public PooledObject makeObject() throws Exception {
        return new DefaultPooledObject(new User());
    }

    public void destroyObject(PooledObject<User> pooledObject) throws Exception {
        pooledObject.getObject().destroy();
    }

    public boolean validateObject(PooledObject<User> pooledObject) {
        return pooledObject.getObject().isActive();
    }

    public void activateObject(PooledObject<User> pooledObject) throws Exception {
        pooledObject.getObject().setActive(true);
    }

    public void passivateObject(PooledObject pooledObject) throws Exception {

    }
}
