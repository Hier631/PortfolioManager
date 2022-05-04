package org.example;

import com.formdev.flatlaf.intellijthemes.FlatHiberbeeDarkIJTheme;

public class App 
{
    public static void main( String[] args )
    {
        FlatHiberbeeDarkIJTheme.setup();
        new MainView();

        // CayenneUtil.shutdown();
    }
}
