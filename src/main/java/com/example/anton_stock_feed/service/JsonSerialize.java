package com.example.anton_stock_feed.service;

import java.util.Collection;

public interface JsonSerialize {
    String serialize(Object company);

    String serialize(Collection companies);

    Object deserialize(String json);
}
