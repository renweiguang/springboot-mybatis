package com.rwg.annotation;

import java.lang.annotation.*;

/**
 * @author rwg
 * @date 2021/11/26 16:59
 */

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface MyAnno {
    public String name() default "zhangsan";
    public String email() default "hello@example.com";
}
