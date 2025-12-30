package Collections.comparator;

import java.util.Comparator;

public class Car implements Comparator<Car> {
    String name;
    int year;

    public Car(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.name + " : " + this.year;
    }

    @Override
    public int compare(Car c1, Car c2) {
        return Integer.compare(c1.year, c2.year);//c1.toString().compareTo(c2.toString());
    }
}
