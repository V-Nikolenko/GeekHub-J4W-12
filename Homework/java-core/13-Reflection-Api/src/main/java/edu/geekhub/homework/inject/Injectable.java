package edu.geekhub.homework.inject;

public @interface Injectable {
    public String propertyName() default "";
}
