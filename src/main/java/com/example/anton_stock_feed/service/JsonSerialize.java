package com.example.anton_stock_feed.service;

import java.util.Collection;

public interface JsonSerialize<T> {
    String serialize(T t);

    Collection<T> deserializeToCollection(String json, Class<T> clazz);
}
