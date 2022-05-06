package org.example;

import net.miginfocom.swing.MigLayout;
import org.example.customizedcomponents.CustomizedTable;

import javax.swing.*;

public class MainView extends JFrame {

    public static final String APP_TITLE = "Portfolio Manager";

    public MainView() {
        super(APP_TITLE);
        this.setLayout(new MigLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(new FundView(), "grow, push");

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
