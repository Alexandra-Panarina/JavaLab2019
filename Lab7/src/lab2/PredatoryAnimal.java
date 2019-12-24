package lab2;

public class PredatoryAnimal extends AbstractAnimal {
    PredatoryAnimal(String name, int foodCount) {
        super(name, foodCount);
    }

    @Override
    public int getFoodType() {
        return 2;
    }
}
