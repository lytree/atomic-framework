package top.lytree.aop;

public class WorldServiceImpl implements WorldService {
    @Override
    public void explode() {
        System.out.println("The Earth is going to explode");
    }

    @Override
    public void explode1() {
        System.out.println("The Earth is going to explode1");
    }
}
