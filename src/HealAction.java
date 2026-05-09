public class HealAction implements Action {
    @Override
    public void apply(Cat cat) {
        cat.setHealth(cat.getHealth() + cat.getIncreaseStep());
        cat.setMood(cat.getMood() - cat.getDecreaseStep());
        cat.setSatiety(cat.getSatiety() - cat.getDecreaseStep());
        System.out.println("Вы отвели кота " + cat.getName() + " к ветеринару");
    }

    @Override
    public String getDescription() {
        return "к ветеринару";
    }
}
