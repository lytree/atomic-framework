package top.lytree.bean.factory.support;

import top.lytree.bean.BeansException;
import top.lytree.bean.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略
 */
public interface InstantiationStrategy {
    /**
     * @param beanDefinition bean 定义
     * @param beanName       bean 名称
     * @param ctor           bean的构造函数
     * @param args           bean的构造参数
     * @return 返回bean
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
