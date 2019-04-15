package cn.mydemo.listener;


/**
 * 事件对象Even
 *
 * 事件对象封装了事件源
 *
 * 在监听器上能够通过事件对象获取得到事件源
 *
 *
 */
class MyEvent {
    private Person person;

    public MyEvent() {
    }

    public MyEvent(Person person) {
        this.person = person;
    }

    public Person getResource() {
        return person;
    }

}
