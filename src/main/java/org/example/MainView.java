package org.example;

import net.miginfocom.swing.MigLayout;
import org.example.customizedcomponents.CustomizedTable;

import javax.swing.*;

public class MainView extends JFrame {

    public static final String APP_TITLE = "Portfolio Manager";

    private JPanel panel;
    private boolean isFirstPanel = true;

    public MainView() {
        super(APP_TITLE);
        this.setLayout(new MigLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void setPanel(JPanel panel) {
        if (panel != null) {
            if (this.panel != null) {
                this.remove(this.panel);
            }
            this.panel = panel;
            this.add(panel, "grow, push");

            if (isFirstPanel) {
                this.pack();
                this.setVisible(true);
                isFirstPanel = false;
            }
            else {
                this.revalidate();
                this.repaint();
            }
        }
    }
}
