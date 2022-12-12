package pizza.util;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContext {
    private final AnnotationConfigApplicationContext context;
    private volatile static ApplicationContext instance = null;

    public ApplicationContext() {
        this.context = new AnnotationConfigApplicationContext(ProjectConfig.class);
    }

    public static AnnotationConfigApplicationContext getContext() {
        synchronized (ApplicationContext.class) {
            if (instance == null) {
                instance = new ApplicationContext();
            }
        }
        return instance.context;
    }
}