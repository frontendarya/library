package com.example.libs.common.error;

public class BookUnavailableException extends RuntimeException{
    public BookUnavailableException (String msg){
        super(msg);
    }
}
