package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;

public class Console extends OutputStream {
    private JTextArea output;
    public Console(JTextArea ta) {
        this.output = ta;
    }
    @Override
    public void write(int i) throws IOException {
        output.append(String.valueOf((char) i));
    }
}