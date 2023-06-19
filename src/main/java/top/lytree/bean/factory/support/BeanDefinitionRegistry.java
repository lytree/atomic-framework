package top.lytree.bean.factory.support;

import top.lytree.bean.factory.config.BeanDefinition;

/**
 * BeanDefinition 注册
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
