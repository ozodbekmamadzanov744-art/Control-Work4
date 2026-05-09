import java.util.*;
public class Menu {
    private final Scanner scanner;
    private final List<Cat> cats;
    private final Printable table;
    private final CatInput catInput;
    private final CatSelector catSelector;

    private final List<Action> actions = Arrays.asList(
            new FeedAction(),
            new PlayAction(),
            new HealAction()
    );

    public Menu(Scanner scanner, List<Cat> cats) {
        this.scanner = scanner;
        this.cats = cats;
        this.table = new CatTable(cats);
        this.catInput = new CatInput(scanner);
        this.catSelector = new CatSelector(scanner);
    }

    public void run() {
        while (true) {
            table.print();
            printActions();

            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("a")) {
                Cat newCat = catInput.createCat();
                cats.add(newCat);
                System.out.println("Кот добавлен!\n");
                continue;
            }


            int actionIndex;
            try {
                actionIndex = Integer.parseInt(choice) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите номер действия или 'a'!\n");
                continue;
            }

            if (actionIndex < 0 || actionIndex >= actions.size()) {
                System.out.println("Ошибка: неверный номер действия!\n");
                continue;
            }

            Cat cat = catSelector.select(cats);
            if (cat == null) {
                System.out.println("Ошибка: кот не найден!\n");
                continue;
            }

            actions.get(actionIndex).apply(cat);
            System.out.println();
        }
    }

    private void printActions() {
        for (int i = 0; i < actions.size(); i++) {
            System.out.println((i + 1) + ": " + actions.get(i).getDescription());
        }
        System.out.println("a: завести нового питомца");
    }
}
