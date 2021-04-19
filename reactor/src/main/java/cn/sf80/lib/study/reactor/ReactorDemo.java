package cn.sf80.lib.study.reactor;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.List;

/**
 * @author wangcongjun
 * @date 2021/4/14 10:32
 */
public class ReactorDemo {
    public static void main(String[] args) throws Exception{
//        get();
        Flux<User> flux = getFlux();
        Flux<User> flux1 = getFlux1();


        flux.publishOn(Schedulers.newSingle("1")).subscribe(new Subscriber1());
        flux.publishOn(Schedulers.newSingle("2")).subscribe(new Subscriber1());
//        flux.publishOn(Schedulers.newSingle("2")).subscribe(new Subscriber2());

        while (true){

        }
//        testColdPublisher();
//        testConnectableFlux();
    }

    public static void testConnectableFlux() throws InterruptedException {
        Flux<Integer> source = Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("上游收到订阅"));

        ConnectableFlux<Integer> co = source.publish();

        co.subscribe(System.out::println, e -> {}, () -> {});
        co.subscribe(System.out::println, e -> {}, () -> {});

        System.out.println("订阅者完成订阅操作");
        Thread.sleep(500);
        System.out.println("还没有连接上");

        co.connect();
    }

    public static void testColdPublisher() {
        Flux<String> source = Flux.fromIterable(Arrays.asList("blue", "green", "orange", "purple"))
                .map(String::toUpperCase).log();

        source.subscribe(d -> System.out.println("Subscriber 1: "+d));
        System.out.println();
        source.subscribe(d -> System.out.println("Subscriber 2: "+d));
    }



    public static List<User> get(){
        return Arrays.asList(new User("susan"),new User("jerry"));
    }
    public static Flux<User> getFlux(){
        return Flux.just(new User("susan"),new User("jerry")).log();
    }
    public static Flux<User> getFlux1(){
        return Flux.just(new User("susan1"),new User("jerry1")).log();
    }
}
