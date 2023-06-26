package top.lytree.bean.factory;

import top.lytree.bean.BeansException;

import java.util.Map;

/**
 * 迭代Ioc容器持有的Bean对象
 */
public interface ListableBeanFactory  extends BeanFactory {

    /**
     * 返回指定类型的所有实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回定义的所有bean的名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
