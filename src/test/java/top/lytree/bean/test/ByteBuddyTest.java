package top.lytree.bean.test;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import org.junit.Test;
import top.lytree.bean.factory.HelloService;
import top.lytree.bean.factory.HelloServiceInterceptor;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class ByteBuddyTest {
    @Test
    public void ByteBuddyTest1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        DynamicType.Loaded<HelloService> sayHello = new ByteBuddy().subclass(HelloService.class)
                .method(named("sayHello"))
                .intercept(MethodDelegation.to(new HelloServiceInterceptor()))
                .make()
                .load(ByteBuddyTest.class.getClassLoader());
        sayHello.saveIn(new File("D:\\Code\\Github\\atomic-framework\\src\\test\\java\\"));
        HelloService helloService = sayHello
                .getLoaded()
                .getDeclaredConstructor()
                .newInstance();
        String s = helloService.sayHello();
        System.out.println(s);
    }

    public static class BytebuddyService {


        public String sayHello() {
            System.out.println("hello");
            return "hello";
        }

    }

//    public static class HelloServiceInterceptor {
//
//        //    @RuntimeType
//    public  Object interceptor(@This Object proxy, @Origin Method method,
//                              @SuperMethod Method superMethod,
//                              @AllArguments Object[] args) throws Exception {
//        System.out.println("bytebuddy delegate proxy2 before sing ");
//        Object ret = superMethod.invoke(proxy, args);
//        System.out.println("bytebuddy delegate proxy2 after sing ");
//        return ret;
//    }
//        public static String sayHello() {
//            System.out.println("hello bytebuddy ");
//            return "hello bytebuddy ";
//        }
//    }

//    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IOException {
//        DynamicType.Loaded<Object> load = new ByteBuddy()
//                .subclass(Object.class)
//                .name("top.lytree.bean.bytebuddy.DynamicType")
//                .defineField("name", String.class, 1)
//                .defineField("age", Integer.class, 1)
//                .method(named("toString"))
//                .intercept(FixedValue.value("Hello World!"))
//                .make().load(ByteBuddyTest.class.getClassLoader());
//        load.saveIn(new File("D:\\Code\\Github\\atomic-framework\\src\\test\\java\\"));
//    }
}