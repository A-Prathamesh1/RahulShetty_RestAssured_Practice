package Collections.comparable;

import java.util.*;

public class ComparableDemo {
    public static void main(String[] args) {
        Car c1 = new Car("Tesla", 2025);
        Car c2 = new Car("Tata", 2021);
        Car c3 = new Car("Merc", 2024);
        List<Car> carL = new ArrayList<>(Arrays.asList(c1, c2, c3));
        System.out.println("created list of cars");
        System.out.println("Before sorting: " + carL);
        Collections.sort(carL);
        System.out.println("After sorting: " + carL);

        // Use Comparable when you want class's natural order to compare the ele
        //
    }
}
