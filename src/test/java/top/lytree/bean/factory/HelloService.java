package top.lytree.bean.factory;

public class HelloService {

    private String name;

    public HelloService(String name) {
        this.name = name;
    }

    public HelloService() {

    }

    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }

    @Override
    public String toString() {
        return name;
    }
}
