package com.shop.app.utils;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Nested {

    boolean isCollection() default false;

}
