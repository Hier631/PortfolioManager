package org.example;

import org.example.FundView;
import org.example.customizedcomponents.CustomizedTable;
import org.example.model.Dao;
import org.example.model.IndexFundDao;
import org.example.model.IndexFundDto;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class FundController {

    private FundView view;
    private Dao<IndexFundDto, String> dao = new IndexFundDao();

    public FundController(FundView view) {
        this.view = view;
        initView();
    }

    public void initView() {
        updateTable();
    }

    public FundView getView() {
        return view;
    }

    public void initController() {
        view.getBtnAddIndexFund().addActionListener(e -> addFund());
        view.getBtnDeleteIndexFund().addActionListener(e -> deleteFund());
    }

    private void addFund() {
        AddFundController controller = new AddFundController(new AddFundView(view.getMainView()));
        controller.initController();
        view.getMainView().setPanel(controller.getView());
    }

    private void deleteFund() {
        CustomizedTable table = view.getCtbIndexFunds();
        String fundIsin = (String) table.getValueAt(table.getSelectedRow(), table.getColumn("ISIN").getModelIndex());
        dao.deleteById(fundIsin);
        updateTable();
    }

    private void updateTable() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ISIN");
        tableModel.addColumn("Name");

        List<IndexFundDto> indexFundDtoList = dao.getAll();

        if (indexFundDtoList != null) {
            for (IndexFundDto indexFundDto : indexFundDtoList) {
                tableModel.addRow(new Object[] {indexFundDto.getIsin(), indexFundDto.getName()});
            }
        }

        view.getCtbIndexFunds().setModel(tableModel);
    }
}
