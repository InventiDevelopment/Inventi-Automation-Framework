package cz.inventi.qa.framework.core.annotations.api;

import cz.inventi.qa.framework.core.data.enums.api.HttpRequestType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Request {
    HttpRequestType type();
}
