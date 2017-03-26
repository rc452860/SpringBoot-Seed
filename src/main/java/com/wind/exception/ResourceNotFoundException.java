package com.wind.exception;

import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Setter
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private Long id;

    @Override
    public String getMessage() {
        return resourceName + " with id " + id + " is not found.";
    }

}
