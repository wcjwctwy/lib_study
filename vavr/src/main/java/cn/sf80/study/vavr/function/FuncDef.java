package cn.sf80.study.vavr.function;

import io.vavr.Function2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author wangcongjun
 * @date 2020/12/28 11:07
 */
public class FuncDef {
    public static void main(String[] args) {
        Function2<Integer, Integer, String> f2 = (a, b) -> a + b + "";
        String apply = f2.apply(1, 2);
        System.out.println(apply);
    }
}
