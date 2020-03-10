package ComparatorAndComparable;

import com.sun.prism.paint.Color;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("blue", 2004));
        cars.add(new Car("yellow", 2006));
        cars.add(new Car("black", 2000));
        cars.add(new Car("white", 2012));

        System.out.println(cars.toString());

        ColorComparator colorComparator = new ColorComparator();
        cars.sort(colorComparator);

        System.out.println("Sorted: ");
        System.out.println(cars.toString());

    }
}
