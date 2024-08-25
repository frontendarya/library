package com.example.libs.common;

import com.example.libs.common.config.OpenApiConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(OpenApiConfig.class)
public @interface EnableOpenApi {
    String value() default "";
}
