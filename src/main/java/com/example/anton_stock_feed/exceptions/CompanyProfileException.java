package com.example.anton_stock_feed.exceptions;

import com.example.anton_stock_feed.servlets.CompanyProfile;

public class CompanyProfileException extends RuntimeException{

    public CompanyProfileException(Throwable cause) {
        super(cause);
    }
}
