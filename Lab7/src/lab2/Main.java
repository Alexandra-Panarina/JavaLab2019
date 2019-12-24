package lab2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Enter animals.txt file path as first argument and output.txt file path as second argument");

            return;
        }
        String filePath = args[0];
        String outputFilePath = args[1];
        Random random = new Random();
        ArrayList<AbstractAnimal> animals = null;

        try (FileReader fr = new FileReader(filePath)) {
            animals = initializeAnimals(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (AbstractAnimal animal: animals) {
            System.out.println("Name: " + animal.getName() + " Food count: " + animal.getFoodCount() + " Food type: " + animal.getFoodType());
        }
        System.out.println("------------------------");

        Collections.sort(animals, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        animals.forEach(animal -> sb.append(animal.getId()).append(" ")
                .append(animal.getName()).append(" ")
                .append(animal.getFoodType()).append(" ")
                .append(animal.getFoodCount()).append("\n"));

        writeInfo(outputFilePath, sb.toString());

        for (AbstractAnimal animal: animals) {
            System.out.println("Name: " + animal.getName() + " Food count: " + animal.getFoodCount() + " Food type: " + animal.getFoodType());
        }

        System.out.println("First 5 items ------------------------");
        for(AbstractAnimal animal: animals.subList(0, 5)) {
            System.out.println("Name: " + animal.getName() + " Food count: " + animal.getFoodCount() + " Food type: " + animal.getFoodType());
        }

        System.out.println("Last 3 items ------------------------");
        for(AbstractAnimal animal: animals.subList(animals.size() - 3, animals.size())) {
            System.out.println("Name: " + animal.getName() + " Food count: " + animal.getFoodCount() + " Food type: " + animal.getFoodType());
        }

    }

    private static void writeInfo(String path, String info) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(info);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<AbstractAnimal> initializeAnimals(InputStreamReader sr) {
        ArrayList<AbstractAnimal> results = new ArrayList<>();
        Scanner scanner = new Scanner(sr);

        while (scanner.hasNext()) {
            String[] animal = scanner.nextLine().split(" ");

            switch (animal[0]) {
                case "Omnivorous": {
                    results.add(new OmnivorousAnimal(animal[1], Integer.parseInt(animal[2])));
                    break;
                }
                case "Herbivorous": {
                    results.add(new HerbivoreAnimal(animal[1], Integer.parseInt(animal[2])));
                    break;
                }
                case "Predatory": {
                    results.add(new PredatoryAnimal(animal[1], Integer.parseInt(animal[2])));
                    break;
                }

                default: {
                    throw new IllegalArgumentException("Information has invalid data format");
                }
            }
        }

        return results;
    }
}