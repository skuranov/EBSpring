package main.java.quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zivert on 14.08.2015.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("main/java/spring-config.xml");
        context.getBean(Quoter.class).sayQuote();
    }
}
