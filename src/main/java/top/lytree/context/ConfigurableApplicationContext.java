package top.lytree.context;

import top.lytree.bean.BeansException;

/**
 * 上下文功能扩展
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
