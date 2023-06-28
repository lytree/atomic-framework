package top.lytree.bean.common.event;

import top.lytree.context.ApplicationListener;
import top.lytree.context.event.ContextRefreshedEvent;

public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(this.getClass().getName());
    }
}
