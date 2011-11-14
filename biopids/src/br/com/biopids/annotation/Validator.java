package br.com.biopids.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.biopids.validator.AbstractValidator;
import br.com.biopids.validator.IValidator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Validator {
	Class<?>[] validatorClass();
	boolean required() default true;
}
