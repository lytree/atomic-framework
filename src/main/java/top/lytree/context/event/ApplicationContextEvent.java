package top.lytree.context.event;

import top.lytree.context.ApplicationContext;
import top.lytree.context.ApplicationEvent;

public abstract class ApplicationContextEvent extends ApplicationEvent {

    public ApplicationContextEvent(ApplicationContext source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
