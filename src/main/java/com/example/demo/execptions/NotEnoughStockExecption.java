package com.example.demo.execptions;

public class NotEnoughStockExecption extends RuntimeException {
    public NotEnoughStockExecption() {
        super();
    }

    public NotEnoughStockExecption(String s) {
    }

    public NotEnoughStockExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughStockExecption(Throwable cause) {
        super(cause);
    }

    protected NotEnoughStockExecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
