package com.revature.movieapp.util.web;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SecureEndpoint {
    String[] allowedUsers() default {};
    boolean isLoggedIn() default false;
}
