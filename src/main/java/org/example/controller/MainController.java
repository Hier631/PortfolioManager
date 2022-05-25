package org.example.controller;

import org.example.view.FundView;
import org.example.view.MainView;

public class MainController {
    private MainView mainView;

    public MainController(MainView mainView) {
        this.mainView = mainView;
        initView();
    }

    public void initView() {
        SideMenuController sideMenuController = new SideMenuController(mainView.getSideMenuView());
        sideMenuController.initController();

        FundController fundController = new FundController(new FundView(mainView));
        fundController.initController();

        mainView.addCard(fundController.getView(), MainView.FUND_VIEW_ID);
        mainView.showCard(MainView.FUND_VIEW_ID);

        mainView.showView();
    }
}
