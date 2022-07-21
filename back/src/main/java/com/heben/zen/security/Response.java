package com.heben.zen.security;

public class Response {
    private final short status;
    private final String message;
    private  final boolean error;
    public Response(short status, boolean error, String message){
        this.status = status;
        this.message = message;
        this.error = error;
    }

    public short getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public boolean isError() {
        return error;
    }
}
