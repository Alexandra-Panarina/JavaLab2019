package com.company;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Main {
    public static void main(String[] args) {
        Account ac1 = new Account(2000);
        Account ac2 = new Account(2000);
        File file = new File("operations.txt");
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