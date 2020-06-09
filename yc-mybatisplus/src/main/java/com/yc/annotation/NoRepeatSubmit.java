package com.yc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author HHT
 * @version 1.0
 * @date 2020/6/9 0009 22:19
 * @desc 防止重复提交标记注解
 */
@Target(ElementType.METHOD) //作用到方法上
@Retention(RetentionPolicy.RUNTIME) //运行时有效
public @interface NoRepeatSubmit {
}
