package listeners;

import annotations.Failing;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author amalyahayrapetova
 */

public class AnnotationTransformer implements IAnnotationTransformer {
    private boolean isEnabled = false;
    private long timeout = 75;

    @Override
    // Don't change the order of the methods called in transform method,
    // it may cause unwanted results during test execution.
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
            iTestAnnotation.setRetryAnalyzer(Retry.class);
    }


    private void failingTransformer(Method method) {
        final Failing failingClassAnnotation = method.getDeclaringClass().getAnnotation(Failing.class);
        final Failing failingAnnotation = method.getAnnotation(Failing.class);
        if (failingClassAnnotation != null || failingAnnotation != null) {
            isEnabled = false;
        }
    }


    private void setTimeout(ITestAnnotation iTestAnnotation) {
        iTestAnnotation.setTimeOut(timeout * 60 * 1000);
    }

    private void enabledTransformer(ITestAnnotation iTestAnnotation, Method method) {
        Test annotation = null;
        if (method != null) {
            annotation = method.getDeclaringClass().getAnnotation(Test.class);
        }
         if (annotation != null) {
            isEnabled = annotation.enabled();
        } else {
            isEnabled = iTestAnnotation.getEnabled();
        }
    }
}



