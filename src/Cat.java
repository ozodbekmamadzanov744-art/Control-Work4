public class Cat {
    private String name;
    private int age;
    private int health;
    private int mood;
    private int satiety;

    public Cat(String name, int age, int health, int mood, int satiety) {
        this.name = name;
        this.age = Math.max(1, Math.min(18, age));
        this.health = clamp(health);
        this.mood = clamp(mood);
        this.satiety = clamp(satiety);
    }

    private int clamp(int value) {
        return Math.max(0, Math.min(100, value));
    }

    public double getAverageLevel() {
        return (health + mood + satiety) / 3.0;
    }

    public String getName()    { return name; }
    public int getAge()        { return age; }
    public int getHealth()     { return health; }
    public int getMood()       { return mood; }
    public int getSatiety()    { return satiety; }

    public void setHealth(int health)   { this.health = clamp(health); }
    public void setMood(int mood)       { this.mood = clamp(mood); }
    public void setSatiety(int satiety) { this.satiety = clamp(satiety); }

    public int getIncreaseStep() {
        if (age <= 5)  return 7;
        if (age <= 10) return 5;
        return 4;
    }

    public int getDecreaseStep() {
        if (age <= 5)  return 3;
        if (age <= 10) return 5;
        return 6;
    }
}
