package top.lytree.context.event;

import top.lytree.context.ApplicationContext;

public class ContextRefreshedEvent extends ApplicationContextEvent {

    public ContextRefreshedEvent(ApplicationContext source) {
        super(source);
    }
}
