package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class MainView extends JFrame {

    public MainView() {
        super("Portfolio Manager");
        this.setLayout(new MigLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
