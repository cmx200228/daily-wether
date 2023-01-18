package com.cmx.dailyweather.common;

import com.cmx.dailyweather.exception.BusinessExceptionEnum;

/**
 * @author 陈蒙欣
 * @date 2022/12/25 23:52
 */
public class ApiRestResponse<T> {
    private static final int SUCCESS_CODE = 10000;
    private static final String SUCCESS_MSG = "SUCCESS";
    private Integer status;
    private String msg;
    private T data;

    public ApiRestResponse(Integer status) {
        this.status = status;
    }

    public ApiRestResponse(String msg) {
        this.msg = msg;
    }

    public ApiRestResponse(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ApiRestResponse(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ApiRestResponse() {
        this(SUCCESS_CODE, SUCCESS_MSG);
    }

    public static <T> ApiRestResponse<T> success() {
        return new ApiRestResponse<>();
    }

    public static <T> ApiRestResponse<T> success(T data) {
        ApiRestResponse<T> apiRestResponse = new ApiRestResponse<>();
        apiRestResponse.setData(data);
        return apiRestResponse;
    }

    public static <T> ApiRestResponse<T> error(Integer code, String msg) {
        return new ApiRestResponse<>(code, msg);
    }

    public static <T> ApiRestResponse<T> error(BusinessExceptionEnum businessExceptionEnum) {
        return new ApiRestResponse<>(businessExceptionEnum.getCode(), businessExceptionEnum.getMessage());
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
