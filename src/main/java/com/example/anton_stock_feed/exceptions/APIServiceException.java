package com.example.anton_stock_feed.exceptions;

public class APIServiceException extends RuntimeException{

    public APIServiceException (Throwable cause) {
        super(cause);
    }
}