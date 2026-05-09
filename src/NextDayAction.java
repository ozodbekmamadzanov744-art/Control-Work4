import java.util.*;
public class NextDayAction {
    private final Random random = new Random();

    public void apply(List<Cat> cats) {
        cats.forEach(cat -> {
            int satietyChange = -(1 + random.nextInt(5));
            int moodChange    = -3 + random.nextInt(7);
            int healthChange  = -3 + random.nextInt(7);


            cat.setSatiety(cat.getSatiety() + satietyChange);
            cat.setMood(cat.getMood() + moodChange);
            cat.setHealth(cat.getHealth() + healthChange);
        });
        System.out.println("Наступил новый день!");
    }
}
