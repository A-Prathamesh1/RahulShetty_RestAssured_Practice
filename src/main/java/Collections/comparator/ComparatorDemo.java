package Collections.comparator;

import java.util.*;

public class ComparatorDemo {
    public static void main(String[] args) {
        Car c1 = new Car("Apple", 2099);
        Car c3 = new Car("bal", 2024);
        Car c4 = new Car("By", 2150);
        Car c2 = new Car("a", 2093);


        List<Car> l = new ArrayList<>(Arrays.asList(c1, c2, c3, c4));
        System.out.println("Before sorting " + l);

        Comparator<Car> comparatorOfCars = new CarComparator();
        // use comparator when you want to use the multiple sorting methods
        // independent of class
        Collections.sort(l, comparatorOfCars);

        System.out.println("after sortingL " + l);

        // sorting with the name of car
        System.out.println("Comparing the name: ");
        Collections.sort(l, new CarNameComparator());
        System.out.println("sorted with name: " + l);
    }
}
