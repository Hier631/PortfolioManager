package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainView extends JFrame {

    public static final String APP_TITLE = "Portfolio Manager";
    public static final String FUND_FORM_VIEW_ID = "FundFormView";
    public static final String FUND_VIEW_ID = "FundView";
    public static final String ORDER_FORM_VIEW_ID = "OrderFormView";
    public static final String ORDER_VIEW_ID = "OrderView";

    private JPanel cards = new JPanel(new CardLayout());
    private Map<String, JPanel> panels = new HashMap<>();
    private boolean isViewShown = false;

    private SideMenuView sideMenuView;

    public SideMenuView getSideMenuView() {
        return sideMenuView;
    }

    public MainView() {
        super(APP_TITLE);

        this.setLayout(new MigLayout("insets 0", "[fill, 20%][fill, 80%]"));
        this.setPreferredSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.sideMenuView = new SideMenuView(this);

        this.add(this.sideMenuView, "gaptop 6px, grow");
        this.add(cards, "grow, push");
    }

    public void showView() {
        if (!this.isViewShown) {
            this.isViewShown = true;

            this.pack();
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }
    }

    public void addCard(JPanel card, String name) {
        if (card != null && name != null && !panels.containsKey(name)) {
            this.panels.put(name, card);
            this.cards.add(card, name);
        }
    }

    public void showCard(String name) {
        if (name != null && panels.containsKey(name)) {
            ((CardLayout) cards.getLayout()).show(cards, name);
        }
    }

    public void removeCard(String name) {
        if (name != null && panels.containsKey(name)) {
            this.cards.remove(this.panels.get(name));
            this.panels.remove(name);
        }
    }
}
