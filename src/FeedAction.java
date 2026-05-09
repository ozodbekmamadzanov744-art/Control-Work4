import java.util.Random;

public class FeedAction implements Action {
    private final Random random = new Random();
    private static final double POISON_CHANCE = 0.2;

    @Override
    public void apply(Cat cat) {
        if (random.nextDouble() < POISON_CHANCE) {
            cat.setMood(cat.getMood() - 20);
            cat.setHealth(cat.getHealth() - 20);
            System.out.println("Кот " + cat.getName() + " отравился! Настроение и здоровье сильно упали ");
        } else {
            cat.setSatiety(cat.getSatiety() + cat.getIncreaseStep());
            cat.setMood(cat.getMood() + cat.getIncreaseStep());
            System.out.println("Вы покормили кота " + cat.getName());
        }
    }

    @Override
    public String getDescription() {
        return "покормить";
    }
}