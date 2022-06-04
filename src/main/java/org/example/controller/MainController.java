package org.example.controller;

import org.apache.cayenne.ObjectContext;
import org.example.utils.CayenneUtil;
import org.example.view.FundView;
import org.example.view.MainView;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainController {

    private ObjectContext context;
    private MainView mainView;

    public MainController(ObjectContext context, MainView mainView) {
        this.context = context;
        this.mainView = mainView;

        initView();
    }

    private void initView() {
        SideMenuController sideMenuController = new SideMenuController(context, mainView.getSideMenuView());
        sideMenuController.initController();

        FundController fundController = new FundController(context, new FundView(mainView));
        fundController.initController();

        mainView.addCard(fundController.getView(), MainView.FUND_VIEW_ID);
        mainView.showCard(MainView.FUND_VIEW_ID);

        mainView.showView();
    }

    public void initController() {
        mainView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                CayenneUtil.shutdown();
            }
        });
    }
}
