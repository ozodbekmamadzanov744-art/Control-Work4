import java.util.*;

public class Menu {
    private final Scanner scanner;
    private final List<Cat> cats;
    private final Printable table;
    private final CatInput catInput;
    private final CatSelector catSelector;
    private final NextDayAction nextDayAction;

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
        this.nextDayAction = new NextDayAction();
    }

    public void run() {
        while (true) {
            table.print();
            printActions();

            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("a")) {
                cats.add(catInput.createCat());
                System.out.println("Кот добавлен!\n");
                continue;
            }

            if (choice.equals("n")) {
                nextDayAction.apply(cats);
                System.out.println();
                continue;
            }

            int actionIndex;
            try {
                actionIndex = Integer.parseInt(choice) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите номер действия, 'a' или 'n'!\n");
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
        System.out.println("n: следующий день");
    }
}