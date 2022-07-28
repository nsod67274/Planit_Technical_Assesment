package annotations;

import enums.AuthorType;
import enums.CategoryType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Framework {
        // This is not a method
        AuthorType[] author();

        // public String[] category();
        CategoryType[] category();
}
