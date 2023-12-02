package com.victor.secretfriend.model;

public class ApiResponse
{
    public ApiResponse()
    {
        this.success = true;
        this.message = null;
    };

    public ApiResponse(String message)
    {
        this.success = false;
        this.message = message;
    };

    public Boolean success;

    public String message;
}
