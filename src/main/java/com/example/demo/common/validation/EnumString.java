package com.example.demo.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {EnumStringValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumString {

    /**
     * 如果该标志为true，则当输入值为NULL或空时，则认为校验通过。默认为false。
     *
     * @return
     * @author wengyongyi
     */
    boolean ignoreNullOrEmpty() default false;

    /**
     * 允许输入的常量值
     *
     * @return
     * @author wengyongyi
     */
    String[] constStrings();

    String message() default "输入的参数值必须是约定的枚举值";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Defines several {@code @EnumString} annotations on the same element.
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        EnumString[] value();
    }
}
