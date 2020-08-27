package com.pain.flame.lab;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaTest {
    public static void main(String[] args) {
        // testStream();
        testCollector();
    }

    private static void testLambda() {
        List<String> courses = Arrays.asList("spark", "hbase", "hive", "kafka", "netty");

        courses.forEach((s) -> {
            upper("hello: " + s);
        });
        courses.forEach(LambdaTest::upper);

        LambdaTest lambdaTest = new LambdaTest();
        courses.forEach(lambdaTest::process);

        Map<String, Integer> scoreMap = new HashMap<>();
        scoreMap.put("宇文泰", 100);
        scoreMap.put("高欢", 90);
        scoreMap.put("侯景", 80);

        scoreMap.forEach(LambdaTest::process);
    }

    private static void testStream() {
        List<String> courses = Arrays.asList("spark", "hbase", "hive", "kafka", "netty");

        courses.stream().filter((s -> s.length() > 4)).map(String::toUpperCase).forEach(System.out::println);
    }

    private static void testCollector() {
        List<String> courses = Arrays.asList("spark", "hbase", "hive", "kafka", "netty");

        courses = courses.stream().filter((s -> s.length() > 4)).map(String::toUpperCase).collect(Collectors.toList());

        courses.forEach(System.out::println);
    }

    private static void upper(String s) {
        System.out.println(s.toUpperCase());
    }

    private void process(String s) {
        System.out.println(s);
    }

    private static void process(String name, Integer score) {
        System.out.println("name: " + name + ", score: " + score);
    }
}
