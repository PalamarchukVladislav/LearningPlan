package InterfaceToLambdaAndViceVersa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Vlad");
        names.add("Mike");
        names.add("Joy");

        FunctionalInterface function = (list) -> list.replaceAll(String::toUpperCase);

        function.listToUpperCase(names);

        System.out.println(names.toString());


        Calculate calculate = (int x, int y) -> x+y;

        int a = calculate.calculate(10,20);

        System.out.println(a);
    }
}
