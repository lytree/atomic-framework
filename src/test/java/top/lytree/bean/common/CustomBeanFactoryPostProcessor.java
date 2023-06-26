package top.lytree.bean.common;

import top.lytree.bean.BeansException;
import top.lytree.bean.PropertyValue;
import top.lytree.bean.PropertyValues;
import top.lytree.bean.factory.ConfigurableListableBeanFactory;
import top.lytree.bean.factory.config.BeanDefinition;
import top.lytree.bean.factory.config.BeanFactoryPostProcessor;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition personBeanDefiniton = beanFactory.getBeanDefinition("person");
        PropertyValues propertyValues = personBeanDefiniton.getPropertyValues();
        //将person的name属性改为ivy
        propertyValues.addPropertyValue(new PropertyValue("name", "ivy"));
    }
}
