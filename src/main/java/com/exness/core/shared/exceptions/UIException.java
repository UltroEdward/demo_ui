package com.exness.core.shared.exceptions;

public class UIException extends CommonException {

    public UIException(String errorMessage) {
        super(errorMessage);
    }

    public UIException(String errorMessage, Exception ex) {
        super(errorMessage, ex);
    }

}
