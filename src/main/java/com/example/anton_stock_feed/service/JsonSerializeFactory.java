package com.example.anton_stock_feed.service;

import org.springframework.stereotype.Component;

@Component
public class JsonSerializeFactory {
    public JsonSerialize createJsonSerialize(String type) {
        JsonSerialize jsonSerialize = null;
        if (type.equals("Gson")) {
            jsonSerialize = JsonSerializeGson.getInstance();
        }
        return jsonSerialize;
    }
}
