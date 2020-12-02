package com.pain.flame.structure.common;

import java.util.Random;

public class RandomUtils {

    private static Random random = new Random();

    {
        random.setSeed(System.currentTimeMillis());
    }

    public static int randomInt(int start, int end) {
        return random.nextInt(end - start) + start;
    }
}
