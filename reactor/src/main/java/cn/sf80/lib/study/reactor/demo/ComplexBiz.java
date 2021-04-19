package cn.sf80.lib.study.reactor.demo;

import cn.sf80.lib.study.reactor.User;

import java.util.Arrays;
import java.util.List;

/**
 * @author wangcongjun
 * @date 2021/4/14 11:32
 */
public class ComplexBiz {
    public List<User> getUsers(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(new User("susan"),new User("jerry"));
    }
    public List<User> getUsers1(){
        return Arrays.asList(new User("susan"),new User("jerry"));
    }
}
