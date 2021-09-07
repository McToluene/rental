package com.mctoluene.rental.dtos.response;

public class Response<T> {
    private T data;
    private boolean succeeded;
    private String message;

    public Response(T data, String message, boolean succeeded) {
        this.data = data;
        this.message = message;
        this.succeeded = succeeded;
    }

    public T getData() {
        return data;
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public String getMessage() {
        return message;
    }
}