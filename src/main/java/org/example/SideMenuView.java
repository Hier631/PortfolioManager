package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SideMenuView extends JPanel {
    public static final int BACKGROUND_COLOR = 0x2d2b29;
    public static final int ITEM_FOREGROUND_COLOR = 0xf9f6ef;
    public static final int SELECTED_ITEM_BACKGROUND_COLOR = 0x242220;
    public static final int SELECTED_ITEM_FOREGROUND_COLOR = 0xffb900;
    public static final int FONT_SIZE = 13;

    public SideMenuView() {
        this.setLayout(new MigLayout("insets 0, gapy 0, wrap 1", "[fill, grow]"));
        this.setBackground(new Color(BACKGROUND_COLOR));

        JLabel lblIndexFunds = new JLabel("Index Funds");
        setSelected(lblIndexFunds, true);

        JLabel lblOrders = new JLabel("Orders");
        setSelected(lblOrders, false);

        this.add(lblIndexFunds);
        this.add(lblOrders);
    }

    public void setSelected(JLabel label, boolean isSelected) {
        label.setFont(new Font(null, Font.PLAIN, FONT_SIZE));
        label.setBorder(new EmptyBorder(3, 15, 3, 50));

        if (isSelected) {
            label.setForeground(new Color(SELECTED_ITEM_FOREGROUND_COLOR));
            label.setBackground(new Color(SELECTED_ITEM_BACKGROUND_COLOR));
        }
        else {
            label.setForeground(new Color(ITEM_FOREGROUND_COLOR));
        }

        label.setOpaque(isSelected);
    }
}