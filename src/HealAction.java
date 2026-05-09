public class HealAction implements Action{
    @Override
    public void apply(Cat cat) {
        System.out.println("Вы отвели кота " + cat.getName() + " к ветеринару");
    }

    @Override
    public String getDescription() {
        return "к ветеринару";
    }
}
