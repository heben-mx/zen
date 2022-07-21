package com.heben.zen.security;

public class Response {
    private final short status;
    private final String message;
    private  final String error;
    private final boolean success;
    public Response(short status, String error, String message, boolean success){
        this.status = status;
        this.message = message;
        this.error = error;
        this.success = success;
    }

    public short getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }

    public boolean isSuccess() {
        return success;
    }
}
