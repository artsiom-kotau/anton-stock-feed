package com.example.anton_stock_feed.classes;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class DataServiceMock extends DataService {
    String jsonString = "{\"currency\":\"USD\",\"description\":\"APPLE INC\",\"displaySymbol\":\"AAPL\",\"figi\":\"BBG000B9XRY4\",\"mic\":\"XNAS\",\"symbol\":\"AAPL\",\"type\":\"Common Stock\"}";
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
