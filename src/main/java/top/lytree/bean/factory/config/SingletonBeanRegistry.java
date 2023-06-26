package top.lytree.bean.factory.config;

import top.lytree.bean.BeansException;

public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
