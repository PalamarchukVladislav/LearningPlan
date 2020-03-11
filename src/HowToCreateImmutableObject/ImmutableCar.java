package HowToCreateImmutableObject;

import java.util.HashMap;

/**
 * Declare the class as final so it can’t be extended. Make all fields private so that direct access is not allowed.
 * Don’t provide setter methods for variables Make all mutable fields final so that it’s value can be assigned only
 * once. Initialize all the fields via a constructor performing deep copy. Perform cloning of objects in the getter
 * methods to return a copy rather than returning the actual object reference.
 */

public final class ImmutableCar {

    private final int speed;
    private final String model;
    private final String color;

    private final HashMap<String, Integer> details;

    public int getSpeed() {
        return speed;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public HashMap<String, Integer> getDetails() {
        return (HashMap<String, Integer>) details.clone();
    }

    /**
     * Constructor performing Deep Copy
     */
//    public ImmutableCar(int speed, String model, String color, HashMap<String, Integer> hm) {
//        System.out.println("Performing Deep Copy for Object initialization...");
//        this.speed = speed;
//        this.model = model;
//        this.color = color;
//
//        HashMap<String, Integer> tempCodeOfCars = new HashMap<>();
//        String key;
//        for (String s : hm.keySet()) {
//            key = s;
//            tempCodeOfCars.put(key, hm.get(key));
//        }
//        this.details = tempCodeOfCars;
//    }

    /**
     * Constructor performing Shallow Copy
     * @param speed
     * @param color
     * @param model
     * @param hm
     */
    public ImmutableCar(int speed, String model, String color, HashMap<String, Integer> hm){
        System.out.println("Performing Shallow Copy for Object initialization...");
        this.speed = speed;
        this.color = color;
        this.model = model;
        this.details = hm;
    }

    /**
     * To test the consequences of Shallow Copy and how to avoid it with Deep Copy for creating immutable classes
     */

    public static void main(String[] args) {

        HashMap<String, Integer> teslaDetails = new HashMap<>();
        teslaDetails.put("battery", 30);
        teslaDetails.put("tires", 499);

        int speed = 330;
        String color = "white";
        String model = "Tesla";

        ImmutableCar immutableCar = new ImmutableCar(speed, model, color, teslaDetails);

        //Lets see whether its copy by field or reference
        System.out.println(speed == immutableCar.getSpeed());
        System.out.println(teslaDetails == immutableCar.getDetails()); /// why it is false
        // print immutable values
        System.out.println("immutable speed " + immutableCar.getSpeed());
        System.out.println("immutable model " + immutableCar.getModel());
        System.out.println("immutable color " + immutableCar.getColor());
        System.out.println("immutable details " + immutableCar.getDetails());
        System.out.println();

        //change the local variable values
        speed = 220;
        color = "black";
        teslaDetails.put("power reserve", 800);

        // print values again
        System.out.println("immutable speed after variable change " + immutableCar.getSpeed());
        System.out.println("immutable model after variable change " + immutableCar.getModel());
        System.out.println("immutable color after variable change " + immutableCar.getColor());
        System.out.println("immutable details after variable change " + immutableCar.getDetails());

        HashMap<String, Integer> teslaDetailsTest = immutableCar.getDetails();
        teslaDetailsTest.put("OneMoreDetail", 4);

        System.out.println("immutable teslaDetailsTest after changing variable from accessor methods: " + immutableCar
                .getDetails());

    }
}
