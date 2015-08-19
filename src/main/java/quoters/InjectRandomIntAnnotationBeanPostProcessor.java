package main.java.quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by zivert on 15.08.2015.
 */
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotatinon = field.getAnnotation(InjectRandomInt.class);
            if (annotatinon!=null){
                int min = annotatinon.min();
                int max = annotatinon.max();
                Random random = new Random();
                int i = min + random.nextInt(max-min);
                field.setAccessible(true);
                ReflectionUtils.setField(field,bean,i);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        return bean;
    }
}
