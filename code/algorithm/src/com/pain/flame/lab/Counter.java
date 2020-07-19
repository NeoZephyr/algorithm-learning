package com.pain.flame.lab;

public class Counter {
    private int count;

    public int getCount() {
        return count;
    }

    public void add10K() {
        for (int i = 0; i < 100000; ++i) {
            count++;
        }
    }
}
