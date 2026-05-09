import java.util.Random;

public class PlayAction implements Action {
    private final Random random = new Random();
    private static final double INJURY_CHANCE = 0.2;

    @Override
    public void apply(Cat cat) {
        if (random.nextDouble() < INJURY_CHANCE) {
            cat.setMood(cat.getMood() - 20);
            cat.setHealth(cat.getHealth() - 20);
            System.out.println("Кот " + cat.getName() + " получил травму! Настроение и здоровье сильно упали ");
        } else {
            cat.setMood(cat.getMood() + cat.getIncreaseStep());
            cat.setHealth(cat.getHealth() + cat.getIncreaseStep());
            cat.setSatiety(cat.getSatiety() - cat.getDecreaseStep());
            System.out.println("Вы поиграли с котом по имени  " + cat.getName() + ", " + cat.getAge() + " лет");
        }
    }

    @Override
    public String getDescription() {
        return "поиграть";
    }
}