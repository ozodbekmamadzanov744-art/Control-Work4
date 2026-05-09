import java.util.*;

public class CatSelector {
    private final Scanner scanner;

    public CatSelector(Scanner scanner) {
        this.scanner = scanner;
    }

    public Cat select(List<Cat> cats) {
        while (true) {
            System.out.print("Enter cat number (1-" + cats.size() + "): ");
            String input = scanner.nextLine().trim();
            try {
                int index = Integer.parseInt(input) - 1;
                if (index >= 0 && index < cats.size()) {
                    return cats.get(index);
                }
                System.out.println("Ошибка: введите число от 1 до " + cats.size() + "!");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число!");
            }
        }
    }
}