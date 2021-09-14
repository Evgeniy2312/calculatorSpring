package by.Matveev;

import by.Matveev.application.Application;
import by.Matveev.application.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Application application = applicationContext.getBean("application", Application.class);
        application.run();
    }
}
