package cn.sf80.lib.study.reactor;

import java.util.function.Consumer;

/**
 * @author wangcongjun
 * @date 2021/4/14 10:43
 */
public class Subscriber2 implements Consumer<User> {
    @Override
    public void accept(User user) {
        System.out.println("无阻塞"+user);
    }
}
