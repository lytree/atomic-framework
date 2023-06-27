package top.lytree.bean.test;

import org.hamcrest.core.IsNull;
import org.junit.Test;
import top.lytree.bean.factory.AwareService;
import top.lytree.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;

public class AwareInterfaceTest {
    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        AwareService helloService = applicationContext.getBean("awareService", AwareService.class);
        assertThat(helloService.getApplicationContext(), IsNull.notNullValue());
        assertThat(helloService.getBeanFactory(), IsNull.notNullValue());
    }
}
