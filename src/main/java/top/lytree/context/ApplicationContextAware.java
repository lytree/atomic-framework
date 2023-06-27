package top.lytree.context;

import top.lytree.bean.BeansException;
import top.lytree.bean.factory.Aware;

public interface ApplicationContextAware  extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
