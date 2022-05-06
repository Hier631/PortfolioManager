package org.example;

import net.miginfocom.swing.MigLayout;
import org.example.customizedcomponents.CustomizedTable;

import javax.swing.*;

public class FundView extends JPanel {

    public FundView() {
        this.setLayout(new MigLayout("", "[sizegroup][sizegroup][sizegroup]"));
        addIndexFundsTable();
        addButtons();
    }

    private void addIndexFundsTable() {
        CustomizedTable ctbIndexFunds = new CustomizedTable();
        JScrollPane spIndexFunds = new JScrollPane(ctbIndexFunds);

        ctbIndexFunds.setShowGrid(true);
        ctbIndexFunds.setEditable(false);
        ctbIndexFunds.setSortable(false);
        ctbIndexFunds.setCellSelectionEnabled(true);

        this.add(spIndexFunds, "grow, push, span");
    }

    private void addButtons() {
        JButton btnAddIndexFund = new JButton("Add");
        JButton btnUpdateIndexFund = new JButton("Update");
        JButton btnDeleteIndexFund = new JButton("Delete");

        btnAddIndexFund.setFocusable(false);
        btnUpdateIndexFund.setFocusable(false);
        btnDeleteIndexFund.setFocusable(false);

        this.add(btnAddIndexFund, "growx, pushx");
        this.add(btnUpdateIndexFund, "growx, pushx");
        this.add(btnDeleteIndexFund, "growx, pushx");
    }
}
