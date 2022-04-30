package org.example.customizedcomponents;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

// TODO: Clear cell selection when clicking outside the table.

public class CustomizedTable extends JTable {

    private boolean editable = true;

    public CustomizedTable() {
        super();
    }

    public CustomizedTable(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isSortable() {
        return this.getTableHeader().isEnabled();
    }

    public void setSortable(boolean sortable) {
        this.getTableHeader().setEnabled(false);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return editable;
    }
}
