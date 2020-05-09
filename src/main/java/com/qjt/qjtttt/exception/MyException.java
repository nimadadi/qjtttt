package com.qjt.qjtttt.exception;

import com.qjt.qjtttt.model.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Logger logger=LoggerFactory.getLogger(MyException.class);

    protected String errorCode;
    protected String errorMsg;

    public MyException() {
        super();
    }

    public MyException(BaseResponse baseResponse) {
        super(baseResponse.getCode());
        this.errorCode = baseResponse.getCode();
        this.errorMsg = baseResponse.getMessage();
    }

    public MyException(BaseResponse baseResponse, Throwable cause) {
        super(baseResponse.getCode(), cause);
        this.errorCode = baseResponse.getCode();
        this.errorMsg = baseResponse.getMessage();
    }

    public MyException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public MyException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public MyException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMessage() {
        return errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}
