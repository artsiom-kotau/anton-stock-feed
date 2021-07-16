package com.example.anton_stock_feed.service;

import com.example.anton_stock_feed.model.Company;
import com.example.anton_stock_feed.model.GenericClass;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class JsonSerializeGson implements JsonSerialize {
    private volatile static JsonSerializeGson jsonSerializeGson;

    private JsonSerializeGson() {

    }

    public static JsonSerializeGson getInstance() {
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
    public String serialize(Object company) {
        return null;
    }

    @Override
    public String serialize(Collection companies) {
        return null;
    }

    @Override
    public Object deserialize(String json) {
        Type companyListType = new TypeToken<Collection<GenericClass>>() {
        }.getType();
        ArrayList<GenericClass> jsonObjects = new Gson().fromJson(json, companyListType);
        return jsonObjects;
    }
}
