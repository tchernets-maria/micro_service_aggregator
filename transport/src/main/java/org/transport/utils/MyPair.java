package org.transport.utils;

public class MyPair<T, K> {
    private T first;
    private K second;

    public MyPair() {
    }

    public MyPair(T first, K second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public K getSecond() {
        return second;
    }

    public void setSecond(K second) {
        this.second = second;
    }
}
