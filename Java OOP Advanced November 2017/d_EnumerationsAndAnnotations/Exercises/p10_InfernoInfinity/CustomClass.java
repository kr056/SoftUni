package d_EnumerationsAndAnnotations.Exercises.p10_InfernoInfinity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface CustomClass {
    String author();

    int revision();

    String description();

    String reviewers();
}
