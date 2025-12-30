package Collections.comparator;

import java.util.Comparator;

public class CarNameComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        return c1.name.length() - c2.name.length();
    }
}
