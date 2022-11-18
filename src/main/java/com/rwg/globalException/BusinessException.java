package com.rwg.globalException;

/**
 * @author renwg
 * @date 2022/11/18
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    /**
     * 错误状态码
     */
    protected Integer code;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 错误提示
     */
    protected String message;


    public BusinessException(Integer errorCode, String errorMsg) {
        this.code = errorCode;
        this.message = errorMsg;
    }
}
