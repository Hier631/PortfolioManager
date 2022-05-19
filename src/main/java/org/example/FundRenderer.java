package org.example;

import org.example.model.IndexFundDto;

import javax.swing.*;
import java.awt.*;

public class FundRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof IndexFundDto) {
            IndexFundDto indexFundDto = (IndexFundDto) value;
            value = String.format("%s - %s", indexFundDto.getIsin(), indexFundDto.getName());
        }

        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    }
}
