package top.lytree.bean.factory.config;

public interface SingletonBeanRegistry {
    Object getSingleton(String beanName, Object... args);
}
