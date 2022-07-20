package com.rwg.exced;

import java.lang.annotation.*;

/**
 * @author renwg
 * @date 2022/7/20
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodAnnotation {
    String name() default "MethodAnnotation";
    String url() default "https://www.cnblogs.com";
}