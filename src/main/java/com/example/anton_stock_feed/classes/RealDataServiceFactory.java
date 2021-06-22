package com.example.anton_stock_feed.classes;

public class RealDataServiceFactory extends DataServiceFactory {
    DataService dataService;

    @Override
    public DataService createDataClass(String type) {
        if (type.equals("Mock")) {
            dataService = new DataServiceMock();
        } else if (type.equals("Database")) {
            dataService = new DataServiceMockDatabase();
        }
        return dataService;
    }
}
