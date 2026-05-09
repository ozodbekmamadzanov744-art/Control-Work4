public class PlayAction implements Action{
    @Override
    public void apply(Cat cat) {
        System.out.println("Вы поиграли с котом по имени " + cat.getName() + ", " + cat.getAge() + " лет");
    }

    @Override
    public String getDescription() {
        return "поиграть";
    }
}
