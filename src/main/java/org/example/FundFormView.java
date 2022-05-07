package org.example;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class FundFormView extends JPanel {

    private MainView mainView;
    private JTextField tfIsin;
    private JTextField tfName;
    private JButton btnOk;
    private JButton btnCancel;

    public MainView getMainView() {
        return mainView;
    }

    public JTextField getTfIsin() {
        return tfIsin;
    }

    public JTextField getTfName() {
        return tfName;
    }

    public JButton getBtnOk()
    {
        return btnOk;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public FundFormView(MainView mainView) {
        this.mainView = mainView;

        this.setLayout(new MigLayout("wrap 1"));
        JLabel lblIsin = new JLabel("ISIN");
        tfIsin = new JTextField();
        JLabel lblName = new JLabel("Name");
        tfName = new JTextField();

        btnOk = new JButton("OK");
        btnCancel = new JButton("Cancel");

        this.add(lblIsin);
        this.add(tfIsin, "growx, pushx");
        this.add(lblName);
        this.add(tfName, "growx, pushx, wrap");

        this.add(btnOk, "bottom, right, pushy, split 2");
        this.add(btnCancel, "bottom");
    }
}
