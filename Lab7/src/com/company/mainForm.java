package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class mainForm extends JFrame {
    private JButton button1;
    private JPanel panel1;
    private JButton laba5Button;
    private JButton laba4Button;
    private JButton laba3Button;
    private JButton laba2Button;
    private JButton laba1Button;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JTextArea textArea6;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JLabel Jlab;
    private JLabel jlab2;
    private JTextField textAppendField;

    public mainForm() {
        setContentPane(panel1);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            }
        });

        Jlab.setText("<html>"+"Задание 1.<br>"+"Сформировать матрицу, состоящую из нулей и единиц, причем количество единиц строго равно количеству строк"+"</html>");
        jlab2.setText("<html>"+"Задание 3.<br>"+"класс StringBuilder с поддержкой операции undo"+"</html>");
        laba1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Console console = new Console(textArea1);
                PrintStream ps = new PrintStream(console, true);
                System.setOut(ps);
                System.setErr(ps);

                String[] s1 = new String[]{""};
                lab1.Main.main(s1);
            }
        });
        laba2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Console console = new Console(textArea2);
                PrintStream ps = new PrintStream(console, true);
                System.setOut(ps);
                System.setErr(ps);

                String[] s2 = textField2.getText().split(" ");

                lab2.Main.main(s2);
            }
        });
        laba3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Console console = new Console(textArea3);
                PrintStream ps = new PrintStream(console, true);
                System.setOut(ps);
                System.setErr(ps);

                String[] s3 = new String[]{""};

                lab3.Main.main(s3);
            }
        });

        laba4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Console console = new Console(textArea4);
                PrintStream ps = new PrintStream(console, true);
                System.setOut(ps);
                System.setErr(ps);

                String[] s4 = new String[]{textField4.getText(), ""};

                lab4.Main.main(s4);

            }
        });
        textField4.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                System.out.println(textField4.getText());
                if (textField4.getText().startsWith("edit")) {
                    textAppendField.setEnabled(true);
                } else {
                    textAppendField.setEnabled(false);
                }
            }
        });
        laba5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Console console = new Console(textArea5);
                PrintStream ps = new PrintStream(console, true);
                System.setOut(ps);
                System.setErr(ps);

                String[] s5 = textField5.getText().split(" ");

                lab5.Main.main(s5);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Console console = new Console(textArea6);
                PrintStream ps = new PrintStream(console, true);
                System.setOut(ps);
                System.setErr(ps);

                String[] s6 = textField6.getText().split(" ");

                lab6.Main.main(s6);
            }
        });
    }

}
