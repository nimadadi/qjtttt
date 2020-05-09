package com.qjt.qjtttt.model;

import com.qjt.qjtttt.exception.CommonEnum;

/**
 * 基础返回类
 *
 * @author XiongNeng
 * @version 1.0
 * @since 2018/1/7
 */
public class BaseResponse<T> {
    /**
     * 响应代码
     */
    private String code;

    /**
     * 说明
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public BaseResponse() {

    }

    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    /**
     * 成功
     *
     * @return
     */
    public static BaseResponse success() {
        return success(null);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static BaseResponse success(Object data) {
        BaseResponse rb = new BaseResponse();
        rb.setCode(CommonEnum.SUCCESS.getResultCode());
        rb.setMessage(CommonEnum.SUCCESS.getResultMsg());
        rb.setData(data);
        return rb;
    }

    /**
     * 失败
     */
    public static BaseResponse error(String code, String message) {
        BaseResponse rb = new BaseResponse();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setData(null);
        return rb;
    }

}
