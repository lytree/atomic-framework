package top.lytree.bean.test;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import top.lytree.bean.PropertyValue;
import top.lytree.bean.PropertyValues;
import top.lytree.bean.core.Car;
import top.lytree.bean.core.Person;
import top.lytree.bean.factory.config.BeanDefinition;
import top.lytree.bean.factory.config.BeanReference;
import top.lytree.bean.factory.support.DefaultListableBeanFactory;

import static org.hamcrest.MatcherAssert.assertThat;

public class PopulateBeanWithPropertyValuesTest {
    @Test
    public void testPopulateBeanWithPropertyValues() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "derek"));
        propertyValues.addPropertyValue(new PropertyValue("age", 18));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
        beanFactory.registerBeanDefinition("person", beanDefinition);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
        assertThat(person.getName(),IsEqual.equalTo("derek"));
        assertThat(person.getAge(),IsEqual.equalTo(18));
    }

    /**
     * 为bean注入bean
     *
     * @throws Exception
     */
    @Test
    public void testPopulateBeanWithBean() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //注册Car实例
        PropertyValues propertyValuesForCar = new PropertyValues();
        propertyValuesForCar.addPropertyValue(new PropertyValue("brand", "porsche"));
        BeanDefinition carBeanDefinition = new BeanDefinition(Car.class, propertyValuesForCar);
        beanFactory.registerBeanDefinition("car", carBeanDefinition);

        //注册Person实例
        PropertyValues propertyValuesForPerson = new PropertyValues();
        propertyValuesForPerson.addPropertyValue(new PropertyValue("name", "derek"));
        propertyValuesForPerson.addPropertyValue(new PropertyValue("age", 18));
        //Person实例依赖Car实例
        propertyValuesForPerson.addPropertyValue(new PropertyValue("car", new BeanReference("car")));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValuesForPerson);
        beanFactory.registerBeanDefinition("person", beanDefinition);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
        assertThat(person.getName(), IsEqual.equalTo("derek"));
        assertThat(person.getAge(),IsEqual.equalTo(18));
        Car car = person.getCar();
        assertThat(car, IsNull.notNullValue());
        assertThat(car,IsEqual.equalTo("porsche"));
    }
}
