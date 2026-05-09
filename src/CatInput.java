import java.util.*;

public class CatInput {
    private final Scanner scanner;
    private final Random random;

    public CatInput(Scanner sc) {
        this.scanner = sc;
        this.random = new Random();
    }

    public Cat createCat() {
        String name = inputName();
        int age = inputAge();
        int health  = randomValue();
        int mood    = randomValue();
        int satiety = randomValue();
        return new Cat(name, age, health, mood, satiety);
    }

    private String inputName() {
        while (true) {
            System.out.print("Введите имя кота: ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("Ошибка: имя не может быть пустым!");
        }
    }

    private int inputAge() {
        while (true) {
            System.out.print("Введите возраст кота (1-18): ");
            String line = scanner.nextLine().trim();
            try {
                int age = Integer.parseInt(line);
                if (age >= 1 && age <= 18) {
                    return age;
                }
                System.out.println("Ошибка: возраст должен быть от 1 до 18!");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число!");
            }
        }
    }

    private int randomValue() {
        return 20 + random.nextInt(61);
    }
}