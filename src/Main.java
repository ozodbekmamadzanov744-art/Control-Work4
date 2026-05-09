import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Cat> cats = new ArrayList<>(Arrays.asList(
                new Cat("Peach",  11, 78, 86, 50),
                new Cat("Jasper", 12, 83, 39, 43),
                new Cat("Poppy",   9, 38, 57, 71)
        ));

        Printable table = new CatTable(cats);
        table.print();




    }
}