package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class OrderFormView extends JPanel {

    private MainView mainView;

    public MainView getMainView() {
        return mainView;
    }

    public OrderFormView(MainView mainView) {
        this.mainView = mainView;

        this.setLayout(new MigLayout("wrap 1"));
        JLabel lblDate = new JLabel("Date");
        JLabel lblPurchaseSale = new JLabel("Purchase / Sale");
        JLabel lblSharePrice = new JLabel("Share Price");
        JLabel lblShareQuantity = new JLabel("Share Quantity");

        YearSpinnerNumberModel yearModel = new YearSpinnerNumberModel();
        MonthSpinnerListModel monthModel = new MonthSpinnerListModel(yearModel);
        DaySpinnerNumberModel dayModel = new DaySpinnerNumberModel(monthModel, yearModel);

        JSpinner spnDay = new JSpinner(dayModel);
        JSpinner spnMonth = new JSpinner(monthModel);
        JSpinner spnYear = new JSpinner(yearModel);

        spnYear.setEditor(new JSpinner.NumberEditor(spnYear, "#"));

        JComboBox<String> cbPurchaseSale = new JComboBox<String>(new String[] {"Purchase", "Sale"});

        JTextField tfSharePrice = new JTextField();
        JTextField tfShareQuantity = new JTextField();

        JButton btnOk = new JButton("OK");
        JButton btnCancel = new JButton("Cancel");

        this.add(lblShareQuantity);
        this.add(tfShareQuantity, "growx, pushx");
        this.add(lblSharePrice, "wrap");
        this.add(tfSharePrice, "growx, pushx");
        this.add(lblDate);
        this.add(spnDay, "sizegroup, split 3");
        this.add(spnMonth, "sizegroup");
        this.add(spnYear, "sizegroup");
        this.add(lblPurchaseSale);
        this.add(cbPurchaseSale);

        this.add(btnOk, "bottom, right, pushy, split2");
        this.add(btnCancel, "bottom");
    }
}
