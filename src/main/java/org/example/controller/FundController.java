package org.example.controller;

import org.apache.cayenne.ObjectContext;
import org.example.customizedcomponent.CustomizedTable;
import org.example.model.Dao;
import org.example.model.IndexFundDao;
import org.example.model.IndexFundDto;
import org.example.view.FundFormView;
import org.example.view.FundView;
import org.example.view.MainView;

import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FundController {

    private FundView view;
    private ObjectContext context;
    private Dao<IndexFundDto, Integer> dao;
    private Map<String, Integer> fundIsinToId;

    public FundController(ObjectContext context, FundView view) {
        this.context = context;
        this.dao = new IndexFundDao(context);
        this.view = view;

        initView();
    }

    private void initView() {
        view.setOnUpdateListener(this::updateTable);
        updateTable();
    }

    public FundView getView() {
        return view;
    }

    public void initController() {
        view.getBtnAddIndexFund().addActionListener(e -> addFund());
        view.getBtnUpdateIndexFund().addActionListener(e -> updateFund());
        view.getBtnDeleteIndexFund().addActionListener(e -> deleteFund());
    }

    private void addFund() {
        FundFormController controller = new FundFormController(context, new FundFormView(view.getMainView()));
        controller.initController();

        view.getMainView().addCard(controller.getView(), MainView.FUND_FORM_VIEW_ID);
        view.getMainView().showCard(MainView.FUND_FORM_VIEW_ID);
    }

    private void updateFund() {
        FundFormController controller = new FundFormController(
                context, new FundFormView(view.getMainView()), getSelectedFundId());
        controller.initController();

        view.getMainView().addCard(controller.getView(), MainView.FUND_FORM_VIEW_ID);
        view.getMainView().showCard(MainView.FUND_FORM_VIEW_ID);
    }

    private void deleteFund() {
        dao.deleteById(getSelectedFundId());
        updateTable();
    }

    private int getSelectedFundId() {
        CustomizedTable table = view.getCtbIndexFunds();
        String fundIsin = (String) table.getValueAt(table.getSelectedRow(), table.getColumn("ISIN").getModelIndex());
        return fundIsinToId.get(fundIsin);
    }

    private void updateTable() {
        DefaultTableModel tableModel = new DefaultTableModel();

        tableModel.addColumn("ISIN");
        tableModel.addColumn("Name");

        List<IndexFundDto> indexFundDtoList = dao.getAll();
        fundIsinToId = new HashMap<>();

        if (indexFundDtoList != null) {
            for (IndexFundDto indexFundDto : indexFundDtoList) {
                fundIsinToId.put(indexFundDto.getIsin(), indexFundDto.getId());
                tableModel.addRow(new Object[] {indexFundDto.getIsin(), indexFundDto.getName()});
            }
        }

        view.getCtbIndexFunds().setModel(tableModel);
    }
}
