package Annotations;

import JavaGenerics.Animal;

@VeryImportant
public class Cat extends Animal {
    @ImportantString
    String name;

    public Cat(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("Cat eats");
    }

    @RunImmediately(times = 3)
    public void purr() {
        System.out.println("Purr purr!");
    }
}
