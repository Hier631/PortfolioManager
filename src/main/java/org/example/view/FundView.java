package org.example.view;

import net.miginfocom.swing.MigLayout;
import org.example.customizedcomponents.CustomizedTable;

import javax.swing.*;

public class FundView extends JPanel {

    private MainView mainView;

    private CustomizedTable ctbIndexFunds;
    private JButton btnAddIndexFund;
    private JButton btnDeleteIndexFund;
    private JButton btnUpdateIndexFund;

    public FundView(MainView mainView) {
        this.mainView = mainView;

        this.setLayout(new MigLayout("wrap 3", "[sizegroup][sizegroup][sizegroup]"));
        addButtons();
        addIndexFundsTable();
    }

    private void addIndexFundsTable() {
        ctbIndexFunds = new CustomizedTable();
        JScrollPane spIndexFunds = new JScrollPane(ctbIndexFunds);

        ctbIndexFunds.setShowGrid(true);
        ctbIndexFunds.setEditable(false);
        ctbIndexFunds.setSortable(false);
        ctbIndexFunds.setCellSelectionEnabled(true);

        this.add(spIndexFunds, "grow, push, span");
    }

    private void addButtons() {
        btnAddIndexFund = new JButton("Add");
        btnUpdateIndexFund = new JButton("Update");
        btnDeleteIndexFund = new JButton("Delete");

        btnAddIndexFund.setFocusable(false);
        btnUpdateIndexFund.setFocusable(false);
        btnDeleteIndexFund.setFocusable(false);

        this.add(btnAddIndexFund, "growx, pushx");
        this.add(btnUpdateIndexFund, "growx, pushx");
        this.add(btnDeleteIndexFund, "growx, pushx");
    }

    public MainView getMainView() {
        return mainView;
    }

    public JButton getBtnAddIndexFund() {
        return btnAddIndexFund;
    }

    public JButton getBtnUpdateIndexFund() {
        return btnUpdateIndexFund;
    }

    public JButton getBtnDeleteIndexFund() {
        return btnDeleteIndexFund;
    }

    public CustomizedTable getCtbIndexFunds() {
        return ctbIndexFunds;
    }
}
