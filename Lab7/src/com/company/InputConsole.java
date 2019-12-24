package com.company;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;

public class InputConsole extends InputStream {
    private JTextArea input;
    public InputConsole(JTextArea ta) {
        this.input = ta;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }
}
