package org.example.view;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class MessageView extends JPanel {

    public static final String INDEX_FUND_NOT_FOUND_MESSAGE = "You must add an index fund to see its orders! :)";

    private JLabel lblMessage;

    public MessageView(String message) {
        this.setLayout(new MigLayout("fill", "center"));

        lblMessage = new JLabel(message);
        lblMessage.setFont(new Font(null, Font.PLAIN, 16));

        this.add(lblMessage);
    }

    public void setMessage(String message) {
        lblMessage.setText(message);
    }
}
