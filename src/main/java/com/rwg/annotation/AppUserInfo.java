package com.rwg.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author rwg
 * 自定义注解:里面含有所有方法所共用的属性，比如设置为true，那么所有引用该注解的方法，将都会判断是否为true
 * 这个注解在这个地方的作用， 如果加上了就会去请求头判断是否有token，才获取用户信息，没加就不会判断。
 * @date 2021/9/7 17:12
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AppUserInfo {
    /**
     * 是否自动注册
     */
    boolean isAutoRegister() default false;

    /**
     * 是否必须要用户信息
     */
    boolean isMustGetUserInfo() default true;
}
