package com.project.fenix.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {
    private String mensaje;
}
