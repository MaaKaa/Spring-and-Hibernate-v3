package pl.coderslab.app;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StartWithValidatorClass.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StartWith {
    String value();
    String message() default ("custom.validator.message");
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
