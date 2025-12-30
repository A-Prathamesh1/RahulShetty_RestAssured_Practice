package Collections.comparable;

public class Car implements Comparable<Car> {
    String name;
    int year;

    public Car(String name, int year) {
        System.out.println(name + " car created");
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        System.out.println("call to toString " + this.getClass());
        return name + ": " + year;
    }

    @Override
    public int compareTo(Car c) {
        System.out.println("call to compare " + this.name + " : " + c.name);
        return Integer.compare(this.year, c.year);
    }
}
