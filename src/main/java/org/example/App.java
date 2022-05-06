package org.example;

import com.formdev.flatlaf.intellijthemes.FlatHiberbeeDarkIJTheme;

public class App 
{
    public static void main( String[] args )
    {
        FlatHiberbeeDarkIJTheme.setup();

        new MainController(new MainView());

        // CayenneUtil.shutdown();
    }
}
