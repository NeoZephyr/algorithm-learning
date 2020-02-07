package com.pain.flame.structure.array;

public class Array {
    public int[] data;
    public int capacity;
    public int count;

    public Array(int capacity) {
        data = new int[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= count) {
            throw new RuntimeException("invalid index");
        }

        return data[index];
    }

    public boolean insert(int index, int value) {
        if (count == capacity) {
            return false;
        }

        if (index < 0 || index > count) {
            return false;
        }

        int pos = count - 1;

        while (pos >= index) {
            data[pos + 1] = data[pos];
            pos--;
        }

        count++;
        data[index] = value;

        return true;
    }

    public boolean delete(int index) {
        if (count == 0) {
            return false;
        }

        if (index < 0 || index >= count) {
            return false;
        }

        int pos = index + 1;

        while (pos < count) {
            data[pos - 1] = data[pos];
        }

        count--;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.insert(0, 4);
        array.insert(0, 5);
        array.insert(1, 9);
        array.insert(1, 10);
        array.insert(2, 12);
        array.printAll();
    }
}
