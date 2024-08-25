package com.example.libs.common.error;

public class ResourceNotFoundException extends  RuntimeException{
    public ResourceNotFoundException (String msg){
        super(msg);
    }
}
