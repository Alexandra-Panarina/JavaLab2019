public class HerbivoreAnimal extends AbstractAnimal {
    HerbivoreAnimal(String name, int foodCount) {
        super(name, foodCount);
    }

    @Override
    public int getFoodType() {
        return 1;
    }
}
