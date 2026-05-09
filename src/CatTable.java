import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CatTable implements Printable{
    private final List<Cat> cats;

    public CatTable(List<Cat> cats) {
        this.cats = cats;
    }

    @Override
    public void print() {
        String line = "---+--------+---------+----------+------------+---------+----------------+";
        System.out.println(line);
        System.out.printf(" # | %-6s | %-7s | %-8s | %-10s | %-7s | %-14s |%n",
                "имя", "возраст", "здоровье", "настроение", "сытость", "средний уровень");
        System.out.println(line);

        List<Cat> sorted = cats.stream()
                .sorted(Comparator.comparingDouble(Cat::getAverageLevel).reversed())
                .collect(Collectors.toList());

        for (int i = 0; i < sorted.size(); i++) {
            Cat c = sorted.get(i);
            System.out.printf(" %d | %-6s | %-7d | %-8d | %-10d | %-7d | %-14.0f |%n",
                    i + 1, c.getName(), c.getAge(), c.getHealth(),
                    c.getMood(), c.getSatiety(), c.getAverageLevel());
        }
        System.out.println(line);
    }
}
