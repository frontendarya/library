package com.example.libs.common.config;

import com.example.libs.common.EnableOpenApi;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationPropertiesScan("com.example.libs.common.openapi")
public class OpenApiConfig {
    private final String title;

    public OpenApiConfig(ApplicationContext applicationContext) {
        String[] beanNames = applicationContext.getBeanNamesForAnnotation(EnableOpenApi.class);
        if (beanNames.length == 0) {
            this.title = "";
        } else {
            String beanName = beanNames[0];
            EnableOpenApi enableOpenApi = applicationContext.findAnnotationOnBean(beanName, EnableOpenApi.class);
            if (enableOpenApi == null) {
                this.title = "";
            } else {
                this.title = enableOpenApi.value();
            }
        }
    }
}
