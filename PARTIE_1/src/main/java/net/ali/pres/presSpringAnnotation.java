package net.ali.pres;

import net.ali.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class presSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("net.ali");
        IMetier metier = (IMetier) applicationContext.getBean("metier");
        System.out.println("RES="+metier.calcul());
    }
}
