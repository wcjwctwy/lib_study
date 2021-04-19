package cn.sf80.lib.study.reactor;

/**
 * @author wangcongjun
 * @date 2021/4/14 10:32
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public User(String name) {
        System.out.println("创建用户。。。。。");
        this.name = name;
    }
}
