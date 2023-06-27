package top.lytree.bean.test;

import org.junit.Test;
import top.lytree.context.support.ClassPathXmlApplicationContext;

public class InitializeAndDestroy {
    @Test
    public void testInitAndDestroyMethod() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:init-and-destroy-method.xml");
        applicationContext.registerShutdownHook();  //或者手动关闭 applicationContext.close();
    }
}
