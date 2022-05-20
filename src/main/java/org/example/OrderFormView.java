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

        this.setLayout(new MigLayout());
        JLabel lblDate = new JLabel("Date");

        YearSpinnerNumberModel yearModel = new YearSpinnerNumberModel();
        MonthSpinnerListModel monthModel = new MonthSpinnerListModel(yearModel);
        DaySpinnerNumberModel dayModel = new DaySpinnerNumberModel(monthModel, yearModel);

        JSpinner spnDay = new JSpinner(dayModel);
        JSpinner spnMonth = new JSpinner(monthModel);
        JSpinner spnYear = new JSpinner(yearModel);

        spnYear.setEditor(new JSpinner.NumberEditor(spnYear, "#"));

        this.add(lblDate, "wrap");
        this.add(spnDay, "sizegroup");
        this.add(spnMonth, "sizegroup");
        this.add(spnYear, "sizegroup");
    }
}
