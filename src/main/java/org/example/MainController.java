package org.example;

import javax.swing.*;

public class MainController {
    private MainView mainView;

    public MainController(MainView mainView) {
        this.mainView = mainView;
        initView();
    }

    public void initView() {
        FundController controller = new FundController(new FundView(mainView));
        controller.initController();
        mainView.setPanel(controller.getView());
    }
}
