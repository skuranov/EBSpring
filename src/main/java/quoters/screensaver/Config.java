package main.java.quoters.screensaver;
import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

/**
 * Created by zivert on 17.08.2015.
 */
@Configuration
@ComponentScan(basePackages = "main.java.quoters.screensaver")
public class Config {
    @Bean
    @Scope("periodical")
    public Color color(){
        Random random = new Random();
        return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }
    @Bean
    public ColorFrame frame(){
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };

    }
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while(true){
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(1000);
        }
    }
}
