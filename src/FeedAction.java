public class FeedAction implements Action {
    @Override
    public void apply(Cat cat) {
        cat.setSatiety(cat.getSatiety() + cat.getIncreaseStep());
        cat.setMood(cat.getMood() + cat.getIncreaseStep());
        System.out.println("Вы покормили кота " + cat.getName());
    }

    @Override
    public String getDescription() {
        return "покормить";
    }
}
