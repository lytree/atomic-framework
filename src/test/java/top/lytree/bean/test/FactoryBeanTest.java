package top.lytree.bean.test;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import top.lytree.bean.core.Car;
import top.lytree.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;

public class FactoryBeanTest {
    @Test
    public void testFactoryBean() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:factory-bean.xml");

        Car car = applicationContext.getBean("car", Car.class);
        assertThat(car.getBrand(), IsEqual.equalTo("porsche"));
    }
}
