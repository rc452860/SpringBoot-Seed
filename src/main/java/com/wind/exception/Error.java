package com.wind.exception;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@NoArgsConstructor
@Data
@ToString
public class Error implements Serializable {

    private static final long serialVersionUID = 7660756960387438399L;

    private int code; // Error code
    private String message; // Error message

}
