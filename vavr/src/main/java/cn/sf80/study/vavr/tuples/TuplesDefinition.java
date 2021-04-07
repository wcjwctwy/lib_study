package cn.sf80.study.vavr.tuples;

import io.vavr.Tuple;
import io.vavr.Tuple2;

/**
 * @author wangcongjun
 * @date 2020/12/28 10:58
 */
public class TuplesDefinition {
    public static void main(String[] args) {
        Tuple2<String,Integer> tuple2 = Tuple.of("abc",123);
        System.out.println(tuple2._1+tuple2._2);
        Tuple2<String, Integer> that = tuple2.map(
                s -> s.substring(2) + "vr",
                i -> i / 8
        );
        System.out.println(that);
        // (vavr, 1)
        that = tuple2.map(
                (s, i) -> Tuple.of(s.substring(2) + "vr", i / 8)
        );
        System.out.println(that);
        String res = tuple2.apply(
                (s, i) -> s.substring(2) + "vr " + i / 8
        );
        System.out.println(res);
    }
}
