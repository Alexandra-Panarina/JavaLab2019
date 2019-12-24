package lab2;

public class OmnivorousAnimal extends AbstractAnimal {
    OmnivorousAnimal(String name, int foodCount) {
        super(name, foodCount);
    }

    @Override
    public int getFoodType() {
        return 0;
    }
}
