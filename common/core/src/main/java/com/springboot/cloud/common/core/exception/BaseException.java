package com.springboot.cloud.common.core.exception;

import lombok.Getter;

/**
 * @description:
 * @author: dongxiazi
 * @create: 2020/12/23 10:26
 */
@Getter
public class BaseException extends RuntimeException {
    /**
     *
     */
    private final ErrorType errorType;

    public BaseException() {
        this.errorType=SystemErrorType.SYSTEM_ERROR;
    }

    public BaseException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType,String message) {
        super(message);
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType,String message,Throwable cause) {
        super(message,cause);
        this.errorType = errorType;
    }

}
