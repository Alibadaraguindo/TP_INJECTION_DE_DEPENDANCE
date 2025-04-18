// Main.java
package com.ali.framework.demo;

import com.ali.framework.context.AnnotationBasedContext;

public class Main {
    public static void main(String[] args) {
        AnnotationBasedContext context = new AnnotationBasedContext("com.tonuser.demo");

        IMetier metier = context.getBean(MetierImpl.class);

        System.out.println("Résultat du calcul : " + metier.calcul());
    }
}
