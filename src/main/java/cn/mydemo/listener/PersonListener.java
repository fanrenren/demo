package cn.mydemo.listener;


/**
 * 事件监听器
 *
 * 监听Person事件源的eat和sleep方法
 */
interface PersonListener{

    void doEat(MyEvent event);
    void doSleep(MyEvent event);
}
