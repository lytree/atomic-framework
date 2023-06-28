package top.lytree.context.event;

import top.lytree.context.ApplicationContext;

public class ContextClosedEvent  extends ApplicationContextEvent {

    public ContextClosedEvent(ApplicationContext source) {
        super(source);
    }
}
