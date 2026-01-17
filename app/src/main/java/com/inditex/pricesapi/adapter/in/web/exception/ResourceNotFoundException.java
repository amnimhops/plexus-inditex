package com.inditex.pricesapi.adapter.in.web.exception;

import com.example.app.model.ApiError;

public class ResourceNotFoundException extends RuntimeException{
    private String resourceType;
    public ResourceNotFoundException(String resourceType){
        super();
        this.resourceType = resourceType;
    }
    public ApiError toApiError(){
        return new ApiError(ErrorCode.RESOURCE_NOT_FOUND.name(),resourceType + " not found");
    }
}
