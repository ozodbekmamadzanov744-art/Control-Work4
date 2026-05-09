import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Cat> cats = new ArrayList<>(Arrays.asList(
                new Cat("Peach",  11, 78, 86, 50),
                new Cat("Jasper", 12, 83, 39, 43),
                new Cat("Poppy",   9, 38, 57, 71)
        ));

        Printable table = new CatTable(cats);
        table.print();

        CatInput catInput = new CatInput(sc);
        Cat newCat = catInput.createCat();
        cats.add(newCat);

        System.out.println("\nКот добавлен! Обновлённая таблица:");
        table.print();






    }
}