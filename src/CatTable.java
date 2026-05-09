import java.util.*;
import java.util.stream.*;

public class CatTable implements Printable {
    private final List<Cat> cats;
    private List<Cat> sortedCats;

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

        sortedCats = cats.stream()
                .sorted(Comparator.comparingDouble(Cat::getAverageLevel).reversed())
                .collect(Collectors.toList());

        for (int i = 0; i < sortedCats.size(); i++) {
            Cat c = sortedCats.get(i);
            System.out.printf(" %d | %-6s | %-7d | %-8d | %-10d | %-7d | %-14.0f |%n",
                    i + 1, c.getName(), c.getAge(), c.getHealth(),
                    c.getMood(), c.getSatiety(), c.getAverageLevel());
        }
        System.out.println(line);
    }


    public List<Cat> getSortedCats() {
        return sortedCats != null ? sortedCats : cats;
    }
}