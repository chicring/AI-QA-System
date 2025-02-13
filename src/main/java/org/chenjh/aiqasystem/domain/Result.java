package org.chenjh.aiqasystem.domain;

import com.alibaba.fastjson2.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;

/**
 * @author hjong
 * @date 2025−01−10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 783015033603078674L;
    private int code;
    private String msg;
    private String requestId;
    private T data;

    public static Result<Object> ok() {
        return ok(new HashMap<>(1));
    }
    public static <T> Result<T> ok(T data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

    public static <T> Result<T> ok(T data, String requestId) {
        return new Result<>(ResultCode.SUCCESS, data, requestId);
    }

    public static <T> Result<T> failure(ResultCode code) {
        return failure(code, null);
    }

    public static <T> Result<T> failure(ResultCode code, T o) {
        return new Result<>(code, o);
    }

    public static <T> Result<T> failure(ResultCode code, T o, String requestId) {
        return new Result<>(code, o, requestId);
    }

    public static <T> Result<T> failure(int code, String msg) {
        return new Result<>(code, msg);
    }

    public Result(ResultCode resultCode) {
        setResultCode(resultCode);
    }

    //对象转成JSON
    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(ResultCode resultCode, T data) {
        setResultCode(resultCode);
        this.data = data;
    }

    public Result(ResultCode resultCode, T data, String requestId) {
        setResultCode(resultCode);
        this.data = data;
        this.requestId = requestId;
    }

    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":" + code +
                ", \"msg\":\"" + msg + '\"' +
                ", \"data\":\"" + data + '\"'+
                '}';
    }
}
