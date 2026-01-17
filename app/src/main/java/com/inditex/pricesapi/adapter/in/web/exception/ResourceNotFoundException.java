package com.inditex.pricesapi.adapter.in.web.exception;

import com.inditex.pricesapi.in.web.dto.ApiError;

public class ResourceNotFoundException extends RuntimeException {
    private final String resourceType;

    public ResourceNotFoundException(String resourceType) {
        super();
        this.resourceType = resourceType;
    }

    public ApiError toApiError() {
        return new ApiError(ErrorCode.RESOURCE_NOT_FOUND.name(), resourceType + " not found");
    }
}
