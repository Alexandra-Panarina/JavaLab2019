package com.company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class ConsoleCommander {
    public String[] parseCommand(String command) throws IOException {
        String[] commandAndArg = new String[2];

        if (command.equals("help")) {
            commandAndArg[0] = command;
            return commandAndArg;
        }
        int commandDividerPos = command.indexOf(' ');

        if (commandDividerPos == -1) {
            throw new IOException("Invalid command");
        }

        String comm = command.substring(0, commandDividerPos);
        String argument = command.substring(commandDividerPos).trim();
        commandAndArg[0] = comm;
        commandAndArg[1] = argument;
        return commandAndArg;
    }
    public void dirList(String path) {
        try {
            File[] direcroties = (new File(path).listFiles());
            if (direcroties != null) {
                for (File file : direcroties) {
                    System.out.println(file.getName());
                }
            }
        } catch (InvalidPathException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showFileContent(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createFile(String filePath) {
        try {
            File f = new File(filePath);
            f.createNewFile();
            System.out.println("File created");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteFile(String filePath) {
        File f = new File(filePath);
        f.delete();
        System.out.println("File deleted!");
    }

    public void editFile(String filePath){
        showFileContent(filePath);
        Scanner addup = new Scanner(System.in);
        System.out.println("Add up ... \n");
        try {
            Files.write(Paths.get(filePath), ("\n"+ addup.nextLine()).getBytes(), StandardOpenOption.APPEND);
            showFileContent(filePath);
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}