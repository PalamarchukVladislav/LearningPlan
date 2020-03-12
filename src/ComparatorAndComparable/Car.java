package ComparatorAndComparable;

public class Car {
    private String color;

    private int year;

    public Car(String color, int year) {
        this.color = color;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", year=" + year +
                '}';
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }
}
