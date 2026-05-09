public class FeedAction implements Action {
    @Override
    public void apply(Cat cat) {
        System.out.println("Вы покормили кота " + cat.getName());
    }

    @Override
    public String getDescription() {
        return "покормить";
    }
}
