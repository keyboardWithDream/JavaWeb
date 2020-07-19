package cn.study.l18.proxy;

/**
 * 真实类
 * @author Harlan
 * @date 2020/7/19 19:02
 */
public class Apple implements SaleComputer{

    @Override
    public String sale(double money) {
        System.out.println("花了"+money+"买了一台macBookPro...");
        return "苹果电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑...");
    }
}
