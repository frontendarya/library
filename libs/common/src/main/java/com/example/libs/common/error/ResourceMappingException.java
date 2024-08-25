package com.example.libs.common.error;

/**
 * Ошибки при выполнении modifying запросов
 */

public class ResourceMappingException extends  RuntimeException{
    public ResourceMappingException (String msg){
        super(msg);
    }
}
