package com.example.libs.common;

import com.example.libs.common.util.CorsUtil;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented

@Import(CorsUtil.class)
public @interface EnableCors {
}
