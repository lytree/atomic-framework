package top.lytree.bean.test;

import org.junit.Test;
import top.lytree.bean.common.event.CustomEvent;
import top.lytree.context.support.ClassPathXmlApplicationContext;

public class EventAndEventListenerTest {
    @Test
    public void testEventListener() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:event-and-event-listener.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext));

        applicationContext.registerShutdownHook();//或者applicationContext.close()主动关闭容器;
    }
}
