package top.lytree.bean.factory.config;

import top.lytree.bean.BeansException;

public interface BeanPostProcessor {
    /**
     * 在bean执行初始化方法之前执行此方法
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在bean执行初始化方法之后执行此方法
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
