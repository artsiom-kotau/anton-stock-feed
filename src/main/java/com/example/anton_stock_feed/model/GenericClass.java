package com.example.anton_stock_feed.model;

public class GenericClass<T> {
    private T object;

    public GenericClass(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }
}
