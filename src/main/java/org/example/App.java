package org.example;

import com.formdev.flatlaf.intellijthemes.FlatHiberbeeDarkIJTheme;

public class App 
{
    public static void main( String[] args )
    {
        FlatHiberbeeDarkIJTheme.setup();
        new MainView();

        /*DAO<IndexFund, String> dao = new IndexFundDAO();

        IndexFund testIndexFund1 = new IndexFund("TestISIN", "TestName");
        IndexFund testIndexFund2;

        dao.save(testIndexFund1);
        testIndexFund2 = dao.get(testIndexFund1.getIsin());

        System.out.printf("%s, %s%n", testIndexFund2.getIsin(), testIndexFund2.getName());*/
    }
}
