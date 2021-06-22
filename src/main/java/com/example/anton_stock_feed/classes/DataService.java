package com.example.anton_stock_feed.classes;

import org.json.simple.JSONObject;

public abstract class DataService {
    String info;

    public abstract JSONObject getInfo();
}
