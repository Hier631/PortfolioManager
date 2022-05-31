package org.example.controller;

import org.apache.cayenne.ObjectContext;
import org.example.view.FundView;
import org.example.view.MainView;
import org.example.view.OrderView;
import org.example.view.SideMenuView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SideMenuController extends MouseAdapter {

    private ObjectContext context;
    private SideMenuView view;
    private Font originalFont;

    public SideMenuController(ObjectContext context, SideMenuView view) {
        this.context = context;
        this.view = view;
    }

    public void initController() {
        view.getLblIndexFunds().addMouseListener(this);
        view.getLblOrders().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boolean isSelected = e.getComponent() == view.getLblIndexFunds();

        view.setSelected(view.getLblIndexFunds(), isSelected);
        view.setSelected(view.getLblOrders(), !isSelected);

        if (isSelected) {
            showFundView();
        }
        else {
            showOrderView();
        }
    }

    private void showFundView() {
        removeAllCardsExcept(MainView.FUND_VIEW_ID);

        FundView fundView = (FundView) view.getMainView().getCard(MainView.FUND_VIEW_ID);

        if (fundView == null) {
            FundController fundController = new FundController(context, new FundView(view.getMainView()));
            fundController.initController();

            fundView = fundController.getView();

            view.getMainView().addCard(fundView, MainView.FUND_VIEW_ID);
        }

        fundView.update();
        view.getMainView().showCard(MainView.FUND_VIEW_ID);
    }

    private void showOrderView() {
        removeAllCardsExcept(MainView.ORDER_VIEW_ID);

        OrderView orderView = (OrderView) view.getMainView().getCard(MainView.ORDER_VIEW_ID);

        if (orderView == null) {
            OrderController orderController = new OrderController(context, new OrderView(view.getMainView()));
            orderController.initController();

            orderView = orderController.getView();

            view.getMainView().addCard(orderView, MainView.ORDER_VIEW_ID);
        }

        orderView.update();
        view.getMainView().showCard(MainView.ORDER_VIEW_ID);
    }

    private void removeAllCardsExcept(String cardName) {
        List<String> cardNames = view.getMainView().getCardNames();
        for (String name : cardNames) {
            if (!Objects.equals(name, cardName)) {
                view.getMainView().removeCard(name);
            }
        }
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
}
