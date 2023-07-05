package com.shop.app.utils;

import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER, ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Trim {

}
