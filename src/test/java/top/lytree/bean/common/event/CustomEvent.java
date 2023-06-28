package top.lytree.bean.common.event;

import top.lytree.context.ApplicationContext;
import top.lytree.context.event.ApplicationContextEvent;

public class CustomEvent extends ApplicationContextEvent {
    public CustomEvent(ApplicationContext source) {
        super(source);
    }
}
