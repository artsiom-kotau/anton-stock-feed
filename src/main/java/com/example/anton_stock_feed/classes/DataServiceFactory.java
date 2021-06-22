package com.example.anton_stock_feed.classes;

public abstract class DataServiceFactory {

    public abstract DataService createDataClass (String type);
}
