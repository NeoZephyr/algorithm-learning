package com.pain.flame.structure.array;

public class GenericArray<T> {

    private T[] data;
    private int size;

    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public GenericArray() {
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public int count() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    public boolean contains(T e) {
        if (isEmpty()) {
            return false;
        }

        for (int i = 0; i < size; ++i) {
            if (e.equals(data[i])) {
                return true;
            }
        }

        return false;
    }

    public int find(T e) {
        for (int i = 0; i < size; ++i) {
            if (e.equals(data[i])) {
                return i;
            }
        }

        return -1;
    }

    public void add(int index, T e) {
        checkIndexForAdd(index);

        if (size == data.length) {
            resizeCapacity(data.length * 2);
        }

        int pos = size - 1;

        while (pos >= index) {
            data[pos + 1] = data[pos];
            pos--;
        }

        data[index] = e;
        ++size;
    }

    public void addFirst(T e) {
        add(0, e);
    }

    public void addLast(T e) {
        add(size, e);
    }

    public T remove(int index) {
        checkIndex(index);

        T e = data[index];
        int pos = index + 1;

        while (pos < size) {
            data[pos - 1] = data[pos];
            ++pos;
        }

        --size;
        data[size] = null;

        if (size < data.length / 4) {
            resizeCapacity(data.length / 2);
        }

        return e;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public void removeElement(T e) {
        int pos = find(e);

        if (pos != -1) {
            remove(pos);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Require index >=0 and index < size.");
        }
    }

    private void checkIndexForAdd(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Require index >=0 and index <= size.");
        }
    }

    private void resizeCapacity(int capacity) {
        System.out.println(String.format("resize capacity %d to %d", data.length, capacity));
        T[] newData = (T[]) new Object[capacity];

        for (int i = 0; i < size; ++i) {
            newData[i] = data[i];
        }

        data = newData;
    }

    public static void main(String[] args) {
        GenericArray<String> array = new GenericArray<>(6);
        array.add(0, "java");
        array.add(0, "c++");
        array.add(1, "c#");
        array.add(1, "php");
        array.add(2, "groovy");
        array.add(2, "golang");
        array.add(3, "javascript");

        System.out.println(array);

        array.remove(1);
        array.remove(1);
        array.remove(1);
        array.remove(1);
        array.remove(1);

        System.out.println(array);
    }
}
