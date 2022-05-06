package org.example;

import org.example.model.Dao;
import org.example.model.IndexFundDao;
import org.example.model.IndexFundDto;

public class AddFundController {

    Dao<IndexFundDto, String> dao;

    private AddFundView view;

    public AddFundController(AddFundView view) {
        this.view = view;
        dao = new IndexFundDao();
    }

    public AddFundView getView() {
        return view;
    }

    public void initController() {
        view.getBtnOk().addActionListener(e -> {
            addFund();
            goBack();
        });
        view.getBtnCancel().addActionListener(e -> goBack());
    }

    public void addFund() {
        IndexFundDto indexFundDto = new IndexFundDto(
                view.getTfIsin().getText(),
                view.getTfName().getText()
        );

        dao.save(indexFundDto);
    }

    public void goBack() {
        FundController controller = new FundController(new FundView(view.getMainView()));
        controller.initController();
        view.getMainView().setPanel(controller.getView());
    }
}
