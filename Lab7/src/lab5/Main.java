package lab5;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Enter properties file path");
            return;
        }
        String filePath = args[0];
        try {
            UniversProperties.readPropertiesFile(filePath);
            UniversProperties.props.forEach((elem, val) -> System.out.println(elem + " : " + val));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
