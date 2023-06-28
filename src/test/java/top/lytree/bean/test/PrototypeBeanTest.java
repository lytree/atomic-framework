package top.lytree.bean.test;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import top.lytree.bean.core.Car;
import top.lytree.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.MatcherAssert.assertThat;

public class PrototypeBeanTest {
    @Test
    public void testPrototype() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:prototype-bean.xml");

        Car car1 = applicationContext.getBean("car", Car.class);
        Car car2 = applicationContext.getBean("car", Car.class);
        assertThat(car1 != car2,IsEqual.equalTo(true));
    }
}
