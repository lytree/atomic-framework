package top.lytree.bean.factory;

import top.lytree.bean.BeansException;
import top.lytree.bean.factory.config.AutowireCapableBeanFactory;
import top.lytree.bean.factory.config.BeanDefinition;
import top.lytree.bean.factory.config.BeanPostProcessor;
import top.lytree.bean.factory.config.ConfigurableBeanFactory;

public  interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * 根据名称查找BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException 如果找不到BeanDefintion
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 提前实例化所有单例实例
     *
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}