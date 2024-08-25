package com.example.libs.common.error;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Исключение")
public class ApiErrorResponse {
    @Schema(description = "HTTP статус")
    private Integer status;
    @Schema(description = "Контекстный путь вызова")
    private String path;
    @Schema(description = "Сообщение")
    private String message;
    @Schema(description = "Класс исключения")
    private String exception;
    @Schema(description = "Временная метка")
    private LocalDateTime timestamp;


    public ApiErrorResponse(Integer status, String path, String message, String exception, LocalDateTime timestamp) {
        this.status = status;
        this.path = path;
        this.message = message;
        this.exception = exception;
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
