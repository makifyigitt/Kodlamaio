package com.may.Kodlamaio.core.utilities.result;

public class SuccsessDataResult extends DataResult{
    public SuccsessDataResult( Object data) {
        super(true, data);
    }

    public SuccsessDataResult(String message, Object data) {
        super(true, message, data);
    }
}
