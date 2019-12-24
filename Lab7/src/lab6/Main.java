package lab6;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Enter operations file path");
            return;
        } else if (args[0].length() <= 0) {
            System.out.println("Enter operations file path");
            return;
        }
        String filePath = args[0];

        Account ac1 = new Account(2000);
        Account ac2 = new Account(2000);

        File file = new File(filePath);
        startExchange(file, ac1, ac2);
        System.out.println("----------------------");
        System.out.println("First acc balance: " + ac1.getBalance() + " Second acc balance: " + ac2.getBalance());
    }
    public static void startExchange(File f, Account a1, Account a2) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String st;
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            while ((st = br.readLine()) != null) {
                String[] operation = st.split(" ");
                executorService.submit(() -> {
                    if (operation[0].equals("1")) {
                        a2.changeBalance(+Integer.parseInt(operation[2]));
                        a1.changeBalance(-Integer.parseInt(operation[2]));
                    } else {
                        a1.changeBalance(+Integer.parseInt(operation[2]));
                        a2.changeBalance(-Integer.parseInt(operation[2]));
                    }
                });
            }
            executorService.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}