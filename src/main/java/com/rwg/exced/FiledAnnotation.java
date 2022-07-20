package com.rwg.exced;

import java.lang.annotation.*;

/**
 * @author renwg
 * @date 2022/7/20
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FiledAnnotation {
    String value() default "GetFiledAnnotation";
}

