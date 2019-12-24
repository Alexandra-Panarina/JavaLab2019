package lab2;

import java.util.Comparator;

public abstract class AbstractAnimal implements Comparable<AbstractAnimal> {
    private static int totalIds = 0;
    public int id;
    public String name;
    // public int foodType;
    public int foodCount;

    AbstractAnimal(String name, int foodCount) {
        this.id = totalIds++;
        this.name = name;
        // this.foodType = foodType;
        this.foodCount = foodCount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public abstract int getFoodType();

    @Override
    public int compareTo(AbstractAnimal otherAnimal) {
        return Comparator.comparing(AbstractAnimal::getFoodCount)
                .thenComparing(AbstractAnimal::getName, Comparator.reverseOrder())
                .compare(this, otherAnimal);
    }
}
