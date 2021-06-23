package com.example.anton_stock_feed.classes;

import com.example.anton_stock_feed.exceptions.CompanyProfileException;
import com.example.anton_stock_feed.model.CompanyClass;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class CompanyProfileServiceMock implements CompanyProfileService {
    String jsonStringAAPL = "{\"currency\":\"USD\",\"description\":\"APPLE INC\",\"displaySymbol\":\"AAPL\",\"figi\":\"BBG000B9XRY4\",\"mic\":\"XNAS\",\"symbol\":\"AAPL\",\"type\":\"Common Stock\"}";
    String jsonStringTSLA = "{\"currency\": \"USD\", \"description\": \"TESLA INC\", \"displaySymbol\": \"TSLA\", \"figi\": \"BBG000N9MNX3\", \"mic\": \"XNAS\", \"symbol\": \"TSLA\", \"type\": \"Common Stock\"}";
    JSONObject jsonObject = null;
    CompanyClass companyClass;

    String TAG_CURRENCY = "currency";
    String TAG_DESCRIPTION = "description";
    String TAG_DISPLAY_SYMBOL = "displaySymbol";
    String TAG_FIGI = "figi";
    String TAG_MIC = "mic";
    String TAG_SYMBOL = "symbol";
    String TAG_TYPE = "type";

    @Override
    public CompanyClass getInfo(String companySymbol) {
        if (companySymbol.equals("AAPL")) {
            try {
                jsonObject = (JSONObject) JSONValue.parseWithException(jsonStringAAPL);

                String currency = (String) jsonObject.get(TAG_CURRENCY);
                String description = (String) jsonObject.get(TAG_DESCRIPTION);
                String displaysymbol = (String) jsonObject.get(TAG_DISPLAY_SYMBOL);
                String figi = (String) jsonObject.get(TAG_FIGI);
                String mic = (String) jsonObject.get(TAG_MIC);
                String symbol = (String) jsonObject.get(TAG_SYMBOL);
                String type = (String) jsonObject.get(TAG_TYPE);

                companyClass = new CompanyClass(currency, description, displaysymbol, figi, mic, symbol, type);

            } catch (ParseException e) {
                throw new CompanyProfileException(e);
            }
        } else if (companySymbol.equals("TSLA")) {
            try {
                jsonObject = (JSONObject) JSONValue.parseWithException(jsonStringTSLA);

                String currency = (String) jsonObject.get(TAG_CURRENCY);
                String description = (String) jsonObject.get(TAG_DESCRIPTION);
                String displaysymbol = (String) jsonObject.get(TAG_DISPLAY_SYMBOL);
                String figi = (String) jsonObject.get(TAG_FIGI);
                String mic = (String) jsonObject.get(TAG_MIC);
                String symbol = (String) jsonObject.get(TAG_SYMBOL);
                String type = (String) jsonObject.get(TAG_TYPE);

                companyClass = new CompanyClass(currency, description, displaysymbol, figi, mic, symbol, type);

            } catch (ParseException e) {
                throw new CompanyProfileException(e);
            }
        }

        return companyClass;

    }
}
