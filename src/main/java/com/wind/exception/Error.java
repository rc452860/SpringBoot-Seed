package com.wind.exception;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@NoArgsConstructor
@Data
@ToString
public class Error implements Serializable {
    // Error code
    private int code;

    // Error message
    private String message;

}
