package top.lytree.context.event;

import top.lytree.context.ApplicationContext;

/**
 * 容器关闭事件
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {

    public ContextRefreshedEvent(ApplicationContext source) {
        super(source);
    }
}
