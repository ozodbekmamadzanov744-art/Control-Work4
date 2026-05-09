public class PlayAction implements Action {
    @Override
    public void apply(Cat cat) {
        cat.setMood(cat.getMood() + cat.getIncreaseStep());
        cat.setHealth(cat.getHealth() + cat.getIncreaseStep());
        cat.setSatiety(cat.getSatiety() - cat.getDecreaseStep());
        System.out.println("Вы поиграли с котом по имени  " + cat.getName() + ", " + cat.getAge() + " лет");
    }

    @Override
    public String getDescription() {
        return "поиграть";
    }
}
