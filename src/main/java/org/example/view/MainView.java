package org.example.view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MainView extends JFrame {

    public static final String APP_TITLE = "Portfolio Manager";
    public static final String FUND_FORM_VIEW_ID = "FundFormView";
    public static final String FUND_VIEW_ID = "FundView";
    public static final String ORDER_FORM_VIEW_ID = "OrderFormView";
    public static final String ORDER_VIEW_ID = "OrderView";
    public static final String MESSAGE_VIEW_ID = "MessageView";

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

    /**
     * Returns the card that matches the given card name. If the card is not found, it returns null.
     * @param name the name of the card
     * @return the card that matches the given card name
     */
    public JPanel getCard(String name) {
        JPanel card = null;

        if (name != null && panels.containsKey(name)) {
            card = this.panels.get(name);
        }

        return card;
    }

    /**
     * Returns all unique names of cards added to the MainView object.
     * @return the unique names of the cards
     */
    public List<String> getCardNames() {
        return new ArrayList<String>(panels.keySet());
    }
}
