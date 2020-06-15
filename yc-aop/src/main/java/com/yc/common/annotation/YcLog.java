package com.yc.common.annotation;

import java.lang.annotation.*;

/**
 * @Description: 自定义日志注解类
 * @Author yiChenLove
 * @Date 2020/6/15
 **/

@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface YcLog {
    /**
     * 模块名称
     **/
    public String modulName() default "";
    /**
     * 功能名称
     **/
    public String functionName() default "";

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;
}
