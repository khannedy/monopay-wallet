package com.monopay.wallet.validation;

import com.monopay.wallet.validation.validator.BalanceMustEnoughValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {BalanceMustEnoughValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface BalanceMustEnough {

  String message();

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  boolean withPoint();

}
