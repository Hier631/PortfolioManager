package org.example.view;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class MainViewTest {

    @Test
    public void givenMainViewContainsCard_whenGetCardNames_thenReturnCardName() {
        MainView mainView = new MainView();
        mainView.addCard(new JPanel(), "TestCard");

        String cardName = mainView.getCardNames().get(0);

        Assert.assertEquals(cardName, "TestCard");
    }
}
