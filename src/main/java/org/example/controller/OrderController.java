package org.example.controller;

import org.example.renderer.FundRenderer;
import org.example.model.*;
import org.example.view.MainView;
import org.example.view.OrderFormView;
import org.example.view.OrderView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OrderController {

    private OrderView view;
    private Dao<IndexFundDto, Integer> indexFundDao = new IndexFundDao();
    private Dao<OrderDto, Integer> orderDao = new OrderDao();

    public OrderView getView() {
        return view;
    }

    public OrderController(OrderView view) {
        this.view = view;
        initView();
    }

    private void initView() {
        updateComboBox();
        updateTable();
    }

    public void initController() {
        view.getBtnAddOrder().addActionListener(e -> addOrder());
    }

    private void addOrder() {
        view.getMainView().addCard(new OrderFormView(view.getMainView()), MainView.ORDER_FORM_VIEW_ID);
        view.getMainView().showCard(MainView.ORDER_FORM_VIEW_ID);
    }

    private void updateComboBox() {
        DefaultComboBoxModel<IndexFundDto> comboBoxModel = new DefaultComboBoxModel<>(indexFundDao.getAll().toArray(new IndexFundDto[0]));
        view.getCbIndexFunds().setModel(comboBoxModel);
        view.getCbIndexFunds().setRenderer(new FundRenderer());
    }

    private void updateTable() {
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("Date");
        tableModel.addColumn("Purchase / Sale");
        tableModel.addColumn("Share Price");
        tableModel.addColumn("Share Quantity");

        view.getCtbOrders().setModel(tableModel);
    }
}
