package org.example.view;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class MainViewTest {

    @Test
    public void givenMainViewContainsCard_whenGetCardNames_thenReturnCardName() {
        String cardName1 = "TestCard";
        MainView mainView = new MainView();
        mainView.addCard(new JPanel(), cardName1);

        String cardName2 = mainView.getCardNames().get(0);

        Assert.assertEquals(cardName2, cardName1);
    }

    @Test
    public void givenMainViewContainsCard_whenGetCard_thenReturnCard() {
        JPanel card1 = new JPanel();
        String cardName = "TestCard";
        MainView mainView = new MainView();
        mainView.addCard(card1, cardName);

        JPanel card2 = mainView.getCard(cardName);

        Assert.assertEquals(card1, card2);
    }
}
