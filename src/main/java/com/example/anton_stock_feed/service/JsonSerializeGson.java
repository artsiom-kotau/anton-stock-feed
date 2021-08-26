package com.example.anton_stock_feed.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Collection;

@Component
public class JsonSerializeGson<T> implements JsonSerialize<T> {
    private volatile static JsonSerializeGson<?> jsonSerializeGson;

    private final Gson gson = new Gson();

    private JsonSerializeGson() {

    }

    public static JsonSerializeGson<?> getInstance() {
        if (jsonSerializeGson == null) {
            synchronized (JsonSerializeGson.class) {
                if (jsonSerializeGson == null) {
                    jsonSerializeGson = new JsonSerializeGson();
                }
            }
        }
        return jsonSerializeGson;
    }

    @Override
    public String serialize(T t) {
        return gson.toJson(t);
    }

    @Override
    public Collection<T> deserializeToCollection(String json, Class<T> clazz) {
        Type listType = TypeToken.getParameterized(Collection.class, clazz).getType();
        return gson.fromJson(json, listType);
    }
}
