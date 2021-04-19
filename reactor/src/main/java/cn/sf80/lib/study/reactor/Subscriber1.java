package cn.sf80.lib.study.reactor;

import java.util.function.Consumer;

/**
 * @author wangcongjun
 * @date 2021/4/14 10:43
 */
public class Subscriber1 implements Consumer<User> {
    @Override
    public void accept(User user) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}
