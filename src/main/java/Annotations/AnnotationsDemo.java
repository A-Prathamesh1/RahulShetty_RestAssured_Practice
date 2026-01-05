package Annotations;

import JavaGenerics.Dog;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationsDemo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Cat myCat = new Cat("Stella");
        Dog myDog = new Dog();
        // check if the class is annotated with the very important annotations
        if (myDog.getClass().isAnnotationPresent(VeryImportant.class)) {
            System.out.println(myCat.getClass() + " has annotation " + Arrays.toString(myCat.getClass().getAnnotations()));
        } else {
            System.out.println("its not marked with very imp annotations :(");
        }

        for (Method m : myCat.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(RunImmediately.class)) {
                RunImmediately ann = m.getAnnotation(RunImmediately.class);
                for (int i = 0; i < ann.times(); i++) {
                    m.invoke(myCat);
                }
            }
        }

        for (Field f : myCat.getClass().getDeclaredFields()) {
            Object o = f.get(myCat);
            if (o instanceof String stringValue) {
                System.out.println(stringValue.toUpperCase());
            }
        }
    }
}
