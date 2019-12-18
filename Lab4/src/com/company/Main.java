package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        ConsoleCommander cc = new ConsoleCommander();
        String command;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                command = br.readLine().trim();
                String[] commandWithArg = cc.parseCommand(command);

                switch (commandWithArg[0]) {
                    case "ls":
                        cc.dirList(commandWithArg[1]);
                        break;
                    case "cat":
                        cc.showFileContent(commandWithArg[1]);
                        break;
                    case "touch":
                        cc.createFile(commandWithArg[1]);
                        break;
                    case "rm":
                        cc.deleteFile(commandWithArg[1]);
                        break;
                    case "edit":
                        cc.editFile(commandWithArg[1]);
                        break;
                    case "help":
                        System.out.println("all command:\n"
                                + "ls [file path] Lists files and directories." + "\n"
                                + "touch [file path and file name] Create file." + "\n"
                                + "cat [file path and file name] View file contents." + "\n"
                                + "rm [file path and file name] Delete file." + "\n"
                                + "edit [file path and file name] Add a line to the end of the file." + "\n");
                        break;
                    default:
                        System.out.println("Unknown command");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
