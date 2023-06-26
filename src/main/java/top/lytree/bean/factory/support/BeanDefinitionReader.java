package top.lytree.bean.factory.support;

import top.lytree.bean.BeansException;
import top.lytree.core.io.Resource;
import top.lytree.core.io.ResourceLoader;

/**
 * Bean 定义2读取接口
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}

