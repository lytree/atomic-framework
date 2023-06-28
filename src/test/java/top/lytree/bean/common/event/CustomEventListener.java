package top.lytree.bean.common.event;

import top.lytree.context.ApplicationListener;

public class CustomEventListener  implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println(this.getClass().getName());
    }
}