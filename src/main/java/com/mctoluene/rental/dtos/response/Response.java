package com.mctoluene.rental.dtos.response;

import lombok.Data;

@Data
public class Response<T> {
    private T data;
    private boolean succeeded;
    private String message;

    public Response(T data, String message, boolean succeeded) {
        this.data = data;
        this.message = message;
        this.succeeded = succeeded;
    }
}
