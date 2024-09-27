package com.info.app.projectapp.service.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class BusinessException extends RuntimeException{

    public BusinessException(String mensaje) {
        super(mensaje);
    }

    public BusinessException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
