package ComparatorAndComparable;

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
        cars.add(new Car("aColor", 2020));

        ColorComparator colorComparator = new ColorComparator();
        cars.sort(colorComparator);

        System.out.println("Sorted by color: ");
        for (Car c: cars) {
            System.out.println(c);
        }

        System.out.println("////////////////////////////////////");

        TreeSet<Car> myCars = new TreeSet<>(new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                if (car1.getYear() > car2.getYear()){
                    return 1;
                }
                if (car1.getYear() < car2.getYear()){
                    return -1;
                }else return 0;
            }
        });

        System.out.println("Sorted by year: ");


        myCars.add(new Car("white", 2012));
        myCars.add(new Car("blue", 2004));
        myCars.add(new Car("yellow", 2006));
        myCars.add(new Car("black", 2000));
        myCars.add(new Car("aColor", 2020));

        for (Car c: myCars) {
            System.out.println(c);
        }


        System.out.println("//////////////////");


        TreeSet<House> myHouseArrayList = new TreeSet<>();

        House firstHouse = new House(100, 120000, "Tokyo", true);
        House secondHouse = new House(40, 70000, "Oxford", true);
        House thirdHouse = new House(70, 180000, "Paris", false);

        myHouseArrayList.add(firstHouse);
        myHouseArrayList.add(secondHouse);
        myHouseArrayList.add(thirdHouse);

        System.out.println("Sorted house by area: ");

        for (House h: myHouseArrayList) {
            System.out.println(h);
        }


    }
}
