package com.ali.framework.context;

package com.ali.framework.context;

import java.lang.reflect.*;
import java.util.*;

import com.ali.framework.annotations.Component;
import com.ali.framework.annotations.Inject;
import org.reflections.Reflections;

public class AnnotationBasedContext {
    private Map<Class<?>, Object> beans = new HashMap<>();

    public AnnotationBasedContext(String basePackage) {
        Reflections reflections = new Reflections(basePackage);
        Set<Class<?>> components = reflections.getTypesAnnotatedWith(Component.class);
        for (Class<?> clazz : components) {
            createBean(clazz);
        }
    }

    private Object createBean(Class<?> clazz) {
        if (beans.containsKey(clazz)) return beans.get(clazz);

        try {
            // ➤ Étape 1 : Création par constructeur
            Constructor<?> constructor = Arrays.stream(clazz.getDeclaredConstructors())
                .filter(c -> c.isAnnotationPresent(Inject.class))
                .findFirst()
                .orElse(clazz.getDeclaredConstructor());

            constructor.setAccessible(true);

            // Récupérer les dépendances à injecter dans le constructeur
            Object[] args = Arrays.stream(constructor.getParameterTypes())
                .map(this::createBean) // appel récursif
                .toArray();

            Object instance = constructor.newInstance(args);
            beans.put(clazz, instance); // stocker l’instance

            // ➤ Étape 2 : Injection par champ
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);
                    field.set(instance, createBean(field.getType()));
                }
            }

            // ➤ Étape 3 : Injection par setter
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Inject.class) && method.getParameterCount() == 1) {
                    method.setAccessible(true);
                    method.invoke(instance, createBean(method.getParameterTypes()[0]));
                }
            }

            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la création de " + clazz.getName(), e);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> type) {
        return (T) beans.get(type);
    }
}
