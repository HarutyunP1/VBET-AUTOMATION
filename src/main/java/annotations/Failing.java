package annotations;

import java.lang.annotation.*;

/**
 * @author amalyahayrapetova
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Inherited
public @interface Failing {

    /**
     * Reason why test is failed. Like a bug summery.
     * Please write details.
     * @return
     */
    String reason();

    /**
     * Set issue number. The jira issue key for the bug affecting.
     * @return
     */
    String issue() default "";

    /**
     * The name of person who marks that test as issue.
     * @return
     */
    String user();

    /**
     * The date your are entering the failing test date on.
     * @return
     */
    String createdDate();

}
