package cn.mydemo.listener;


/**
 * 事件源Person
 * <p>
 * 事件源要提供方法注册监听器(即在事件源上关联监听器对象)
 */

class Person {

    //在成员变量定义一个监听器对象
    private PersonListener personListener;

    //在事件源中定义两个方法
    public void Eat() {
        if(personListener != null){
            //当事件源调用了Eat方法时，应该触发监听器的方法，调用监听器的方法并把事件对象传递进去
            personListener.doEat(new MyEvent(this));
        }

    }

    public void sleep() {

        //当事件源调用了Eat方法时，应该触发监听器的方法，调用监听器的方法并把事件对象传递进去
        personListener.doSleep(new MyEvent(this));
    }

    //注册监听器，该类没有监听器对象啊，那么就传递进来吧。
    public void registerLister(PersonListener personListener) {
        this.personListener = personListener;
    }

}

