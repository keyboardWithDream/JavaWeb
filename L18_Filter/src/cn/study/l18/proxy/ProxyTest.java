package cn.study.l18.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Harlan
 * @date 2020/7/19 19:05
 */
public class ProxyTest {

    public static void main(String[] args) {
        //1,创建真实对象
        Apple apple = new Apple();

        //2.动态代理增强Apple对象
        /*
        三个参数:
            1. 类加载器:真实对象
            2. 接口数组:真实对象
            3. 处理器: new InvocationHandler()
         */
        SaleComputer proxy_apple = (SaleComputer) Proxy.newProxyInstance(apple.getClass().getClassLoader(), apple.getClass().getInterfaces(), new InvocationHandler() {

            /*
               代理逻辑编写的方法: 代理对象调用的所有方法都会触发该方法执行
               参数:
                    1. proxy: 代理对象
                    2. method: 代理对象调用的方法被封装为的对象
                    3. args: 代理对象调用方法时, 传递的实际参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("invoke 方法执行...");

                //1.增强参数
                //判断是否是sale方法
                if (method.getName().equals("sale")){
                    double money = (double) args[0];
                    money = money * 0.85;
                    System.out.println("专车接你...");
                    //使用真实对象调用该方法
                    String obj = (String) method.invoke(apple, money);
                    System.out.println("免费送货...");
                    return obj + "_鼠标垫";
                }else {
                    //使用真实对象调用该方法
                    Object obj = method.invoke(apple, args);
                    return obj;
                }

                //2.增强返回值

            }
        });

        //2.调用方法
        String computer = proxy_apple.sale(18000);
        System.out.println(computer);
    }
}
