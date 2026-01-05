package JavaGenerics;

import java.util.*;

public class GenericsDemo {
    public static void main(String[] args) {
//        List<String> list = new ArrayList();
//        list.add("hello");
//        String s = list.get(0);

        Box<String> b = new Box<>();
        b.set("Apple");
        System.out.println("getting b: " + b.get());
        Box<Integer> b1 = new Box<>();
        b1.set(23);
        System.out.println("getting b1: " + b1.get());

        Box<String> stringBox = new Box<>();
        Box rawBox = stringBox;

        Printer<Cat> ip = new Printer<>(new Cat());
        System.out.print("printing cat: ");
        ip.integerPrinter();

        Printer<Dog> dp = new Printer<>(new Dog());
        System.out.println("Double dog");
        dp.integerPrinter();

        Printer<Animal> sp = new Printer<>(new Animal());
        System.out.println("printing animal: ");
        sp.integerPrinter();

        ArrayList<Cat> al = new ArrayList<>();
        al.add(new Cat());
        al.add(new Cat());

        Cat myCat = al.getFirst();
        System.out.println(shout("Shout my name", "brain dump"));

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        printList(catList);

        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        printList(dogList);
    }

    private static <T, V> T shout(T thingToShout, V anotherThing) {
        System.out.println(thingToShout + "!!!!" + anotherThing);
        return thingToShout;
    }

    private static void printList(List<? extends Animal> myList) {
        System.out.println(myList);
    }
}
