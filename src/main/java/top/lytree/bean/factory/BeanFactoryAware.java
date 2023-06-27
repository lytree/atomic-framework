package top.lytree.bean.factory;

import top.lytree.bean.BeansException;
import top.lytree.bean.factory.Aware;

public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
