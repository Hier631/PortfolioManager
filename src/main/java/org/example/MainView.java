package org.example;

import net.miginfocom.swing.MigLayout;
import org.example.customizedcomponents.CustomizedTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// TODO: Clean this code.

public class MainView extends JFrame {

    public MainView() {
        super("Portfolio Manager");
        this.setLayout(new MigLayout("wrap 3", "[sizegroup][sizegroup][sizegroup]"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[][] testData = { { "1", "2", "3", "4", "5" },
                                { "1", "2", "3", "4", "5" },
                                { "1", "2", "3", "4", "5" }, };

        String[] testTitles = { "Title 1", "Title 2", "Title 3", "Title 4", "Title 5" };

        CustomizedTable ctbIndexFunds = new CustomizedTable(testData, testTitles);
        JScrollPane spIndexFunds = new JScrollPane(ctbIndexFunds);

        ctbIndexFunds.setShowGrid(true);
        ctbIndexFunds.setEditable(false);
        ctbIndexFunds.setSortable(false);
        ctbIndexFunds.setCellSelectionEnabled(true);

        JButton btnAddIndexFund = new JButton("Add");
        JButton btnUpdateIndexFund = new JButton("Update");
        JButton btnDeleteIndexFund = new JButton("Delete");

        btnAddIndexFund.setFocusable(false);
        btnUpdateIndexFund.setFocusable(false);
        btnDeleteIndexFund.setFocusable(false);

        this.add(btnAddIndexFund, "growx, pushx");
        this.add(btnUpdateIndexFund, "growx, pushx");
        this.add(btnDeleteIndexFund, "growx, pushx");
        this.add(spIndexFunds, "grow, push, span");


        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
