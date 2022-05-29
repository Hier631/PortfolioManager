package org.example.controller;

import org.apache.cayenne.ObjectContext;
import org.example.model.Dao;
import org.example.model.IndexFundDao;
import org.example.model.IndexFundDto;
import org.example.view.FundFormView;
import org.example.view.MainView;

public class FundFormController {

    private Integer fundId;
    private Updatable updatable;
    private FundFormView view;
    private Dao<IndexFundDto, Integer> dao;

    public FundFormController(ObjectContext context, FundFormView view, Integer fundId) {
        this.dao = new IndexFundDao(context);
        this.view = view;
        this.fundId = fundId;

        initView();
    }

    public FundFormController(ObjectContext context, FundFormView view) {
        this(context, view, null);
    }

    private void initView() {
        if (fundId != null) {
            IndexFundDto indexFundDto = dao.getById(fundId);
            view.getTfIsin().setText(indexFundDto.getIsin());
            view.getTfName().setText(indexFundDto.getName());
        }
    }

    public FundFormView getView() {
        return view;
    }

    public void initController(Updatable updatable) {
        this.updatable = updatable;

        if (fundId == null) {
            view.getBtnOk().addActionListener(e -> {
                addFund();
                goBack();
            });
        }
        else {
            view.getBtnOk().addActionListener(e -> {
                updateFund();
                goBack();
            });
        }

        view.getBtnCancel().addActionListener(e -> goBack());
    }

    private void addFund() {
        IndexFundDto indexFundDto = new IndexFundDto(
                view.getTfIsin().getText(),
                view.getTfName().getText()
        );

        dao.save(indexFundDto);
    }

    private void updateFund() {
        IndexFundDto indexFundDto = dao.getById(fundId);
        indexFundDto.setIsin(view.getTfIsin().getText());
        indexFundDto.setName(view.getTfName().getText());
        dao.update(indexFundDto);
    }

    private void goBack() {
        this.updatable.update();

        view.getMainView().showCard(MainView.FUND_VIEW_ID);
        view.getMainView().removeCard(MainView.FUND_FORM_VIEW_ID);
    }
}
