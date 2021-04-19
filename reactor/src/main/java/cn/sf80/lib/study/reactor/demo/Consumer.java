package cn.sf80.lib.study.reactor.demo;

/**
 * @author wangcongjun
 * @date 2021/4/14 11:33
 */
public class Consumer {
    public static void main(String[] args) {
        ComplexBiz complexBiz = new ComplexBiz();
        complexBiz.getUsers();
        complexBiz.getUsers1();
    }
}
