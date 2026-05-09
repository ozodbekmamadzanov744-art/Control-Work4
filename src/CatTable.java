import java.util.*;
import java.util.stream.*;

public class CatTable implements Printable {
    private final List<Cat> cats;
    private List<Cat> sortedCats;
    private Set<Cat> usedCats = new HashSet<>();

    public CatTable(List<Cat> cats) {
        this.cats = cats;
    }

    public void setUsedCats(Set<Cat> usedCats) {
        this.usedCats = usedCats;
    }

    @Override
    public void print() {
        String line = "---+----------+---------+----------+------------+---------+----------------+";
        System.out.println(line);
        System.out.printf(" # | %-8s | %-7s | %-8s | %-10s | %-7s | %-14s |%n",
                "имя", "возраст", "здоровье", "настроение", "сытость", "средний уровень");
        System.out.println(line);

        sortedCats = cats.stream()
                .sorted(Comparator.comparingDouble(Cat::getAverageLevel).reversed())
                .collect(Collectors.toList());

        for (int i = 0; i < sortedCats.size(); i++) {
            Cat c = sortedCats.get(i);
            String marker = usedCats.contains(c) ? "*" : " ";
            System.out.printf(" %d | %s %-6s | %-7d | %-8d | %-10d | %-7d | %-14.0f |%n",
                    i + 1, marker, c.getName(), c.getAge(), c.getHealth(),
                    c.getMood(), c.getSatiety(), c.getAverageLevel());
        }
        System.out.println(line);
    }

    public List<Cat> getSortedCats() {
        return sortedCats != null ? sortedCats : cats;
    }
}