package top.lytree.bean.factory;


import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import top.lytree.bean.factory.config.BeanDefinition;
import top.lytree.bean.factory.support.DefaultListableBeanFactory;


public class BeanFactoryTest {
    @Test
    public void testGetBean() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
        beanFactory.registerBeanDefinition("helloService", beanDefinition);
        HelloService helloService = (HelloService) beanFactory.getBean("helloService", "测试");
        MatcherAssert.assertThat(helloService, IsNull.notNullValue());
        MatcherAssert.assertThat(helloService.sayHello(), IsEqual.equalTo("hello"));
        System.out.println(helloService);
    }


}
