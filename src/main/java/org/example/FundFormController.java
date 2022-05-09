package org.example;

import org.example.model.Dao;
import org.example.model.IndexFundDao;
import org.example.model.IndexFundDto;

public class FundFormController {

    private Dao<IndexFundDto, Integer> dao;

    private FundFormView view;
    private Integer fundId;

    private Updatable updatable;

    public FundFormController(FundFormView view, Integer fundId) {
        dao = new IndexFundDao();

        this.view = view;
        this.fundId = fundId;

        initView();
    }

    public FundFormController(FundFormView view) {
        this(view, null);
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
        view.getMainView().returnToPreviousPanel();
        this.updatable.update();
    }
}
