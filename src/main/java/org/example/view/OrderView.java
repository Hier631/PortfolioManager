package org.example.view;

import net.miginfocom.swing.MigLayout;
import org.example.customizedcomponents.CustomizedTable;
import org.example.model.IndexFundDto;

import javax.swing.*;

public class OrderView extends JPanel {

    private MainView mainView;
    private JButton btnAddOrder;
    private JButton btnUpdateOrder;
    private JButton btnDeleteOrder;
    private JComboBox<IndexFundDto> cbIndexFunds;
    private CustomizedTable ctbOrders;

    public MainView getMainView() {
        return mainView;
    }

    public JButton getBtnAddOrder() {
        return btnAddOrder;
    }

    public JButton getBtnUpdateOrder() {
        return btnUpdateOrder;
    }

    public JButton getBtnDeleteOrder() {
        return btnDeleteOrder;
    }

    public JComboBox<IndexFundDto> getCbIndexFunds() {
        return cbIndexFunds;
    }

    public CustomizedTable getCtbOrders() {
        return ctbOrders;
    }

    public OrderView(MainView mainView) {
        this.mainView = mainView;

        this.setLayout(new MigLayout("wrap 3", "[sizegroup][sizegroup][sizegroup]"));
        addButtons();
        addComboBox();
        addOrdersTable();
    }

    private void addComboBox() {
        cbIndexFunds = new JComboBox<>();
        this.add(cbIndexFunds, "growx, pushx, span");
    }

    private void addButtons() {
        btnAddOrder = new JButton("Add");
        btnUpdateOrder = new JButton("Update");
        btnDeleteOrder = new JButton("Delete");

        btnAddOrder.setFocusable(false);
        btnUpdateOrder.setFocusable(false);
        btnDeleteOrder.setFocusable(false);

        this.add(btnAddOrder, "growx, pushx");
        this.add(btnUpdateOrder, "growx, pushx");
        this.add(btnDeleteOrder, "growx, pushx");
    }

    private void addOrdersTable() {
        ctbOrders = new CustomizedTable();
        JScrollPane spOrders = new JScrollPane(ctbOrders);

        ctbOrders.setShowGrid(true);
        ctbOrders.setEditable(false);
        ctbOrders.setSortable(false);
        ctbOrders.setCellSelectionEnabled(true);

        this.add(spOrders, "grow, push, span");
    }
}
