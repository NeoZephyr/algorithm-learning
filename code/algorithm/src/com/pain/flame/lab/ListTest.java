package com.pain.flame.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(Arrays.asList("kafka", "stream", "spark", "java"));

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String word = iterator.next();

            if (word.equals("java")) {
                iterator.remove();
            }
        }

        for (String word : list) {
            System.out.println(word);
        }
    }
}
