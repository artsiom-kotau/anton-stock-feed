package com.example.anton_stock_feed.classes;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class DataServiceRealDatabase extends DataService {
    String jsonString = "Data from real database";
    JSONObject jsonObject = null;

    {
        try {
            jsonObject = (JSONObject) JSONValue.parseWithException(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public JSONObject getInfo() {
        return jsonObject;
    }
}
