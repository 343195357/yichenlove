package com.yc.common;

import java.util.Arrays;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/7 0007 16:21
 */
public enum ResultCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");
    private int code;
    private String message;

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 根据code得到枚举的Value
     * Lambda表达式，比较判断（JDK 1.8）
     */
    public static ResultCode getEnummessage(int code) {
        return Arrays.stream(ResultCode.values())
                .filter(resultCode -> resultCode.getCode() == code).findFirst().orElse(ResultCode.SUCCESS);
    }
}
