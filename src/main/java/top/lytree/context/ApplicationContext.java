package top.lytree.context;

import top.lytree.bean.factory.HierarchicalBeanFactory;
import top.lytree.bean.factory.ListableBeanFactory;
import top.lytree.core.io.ResourceLoader;

/**
 * 应用上下文
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {

}
