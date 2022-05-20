package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;

public class SideMenuController {
    private SideMenuView view;

    public SideMenuController(SideMenuView view) {
        this.view = view;
    }

    public void initController() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            private Font originalFont;

            @Override
            public void mouseClicked(MouseEvent e) {
                boolean isSelected = e.getComponent() == view.getLblIndexFunds();

                view.setSelected(view.getLblIndexFunds(), isSelected);
                view.setSelected(view.getLblOrders(), !isSelected);

                // TODO: Delete this code later

                if (!isSelected) {
                    OrderController controller = new OrderController(new OrderView(view.getMainView()));
                    controller.initController();
                    view.getMainView().addCard(controller.getView(), "Test");
                    view.getMainView().showCard("Test");
                }

                // Delete
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                originalFont = e.getComponent().getFont();
                Map attributes = originalFont.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                e.getComponent().setFont(originalFont.deriveFont(attributes));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                e.getComponent().setFont(originalFont);
            }
        };

        view.getLblIndexFunds().addMouseListener(mouseAdapter);
        view.getLblOrders().addMouseListener(mouseAdapter);
    }
}
