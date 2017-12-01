package com.nr.fc.exception;

public class BussinessException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String msg;

    private String errCode;

    public BussinessException() {

        super();
    }

    public BussinessException(String msg) {

        super();
        this.msg = msg;
    }

    public BussinessException(String msg, String errCode) {
        this.msg = msg;
        this.errCode = errCode;
    }

    public BussinessException(String msg, String errCode, Throwable e) {

        super(msg, e);
        this.errCode = errCode;

    }

    public String getMsg() {

        return msg;
    }

    public void setMsg(String msg) {

        this.msg = msg;
    }

    /**
     * @return the errCode
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * @param errCode the errCode to set
     */
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

}
