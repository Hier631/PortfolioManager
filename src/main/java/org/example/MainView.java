package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MainView extends JFrame {

    public static final String APP_TITLE = "Portfolio Manager";

    private List<JPanel> panels = new ArrayList<>();
    private int currentPanelIndex = -1;

    public MainView() {
        super(APP_TITLE);
        this.setLayout(new MigLayout("insets 0", "[fill, 20%][fill, 80%]"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(new SideMenuView(), "gaptop 6px, grow");
    }

    public void setPanel(JPanel panel) {
        if (panel != null) {
            this.panels.add(panel);

            if (currentPanelIndex < 0) {
                this.add(panel, "grow, push");
                this.pack();
                this.setVisible(true);
            }
            else {
                this.remove(panels.get(currentPanelIndex));
                this.add(panel, "grow, push");
                this.revalidate();
                this.repaint();
            }

            currentPanelIndex++;
        }
    }

    public void returnToPreviousPanel() {
        if (currentPanelIndex > 0) {
            this.remove(panels.get(currentPanelIndex));
            this.add(panels.get(currentPanelIndex - 1), "grow, push");
            this.panels.remove(currentPanelIndex);

            this.revalidate();
            this.repaint();

            currentPanelIndex--;
        }
    }
}
