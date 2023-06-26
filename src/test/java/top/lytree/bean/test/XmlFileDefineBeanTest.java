package top.lytree.bean.test;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import top.lytree.bean.core.Car;
import top.lytree.bean.core.Person;
import top.lytree.bean.factory.support.DefaultListableBeanFactory;
import top.lytree.bean.factory.xml.XmlBeanDefinitionReader;

public class XmlFileDefineBeanTest {
    @Test
    public void testXmlFile() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
        MatcherAssert.assertThat(person.getName(), IsEqual.equalTo("derek"));
        MatcherAssert.assertThat(person.getCar().getBrand(),IsEqual.equalTo("porsche"));

        Car car = (Car) beanFactory.getBean("car");
        System.out.println(car);
        MatcherAssert.assertThat(car.getBrand(),IsEqual.equalTo("porsche"));
    }
}
