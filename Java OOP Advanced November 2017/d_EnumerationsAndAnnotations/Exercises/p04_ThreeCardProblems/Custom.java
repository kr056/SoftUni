package d_EnumerationsAndAnnotations.Exercises.p04_ThreeCardProblems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Custom {
    String category() default "";

    String description() default "";

    String type() default "Enumeration";
}
