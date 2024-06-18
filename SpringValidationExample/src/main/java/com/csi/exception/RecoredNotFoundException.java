package com.csi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class RecoredNotFoundException extends RuntimeException{
    public RecoredNotFoundException(String msg){
        super(msg);
    }
}
