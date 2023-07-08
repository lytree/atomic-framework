package top.lytree.context.event;

import top.lytree.context.ApplicationContext;

/**
 * 容器关闭事件
 */
public class ContextClosedEvent extends ApplicationContextEvent {

    public ContextClosedEvent(ApplicationContext source) {
        super(source);
    }
}
