package com.may.Kodlamaio.core.utilities.result;

public class ErrorDataResult extends DataResult{
    public ErrorDataResult(Object data) {
        super(false, data);
    }

    public ErrorDataResult(String message, Object data) {
        super(false, message, data);
    }
}
