package org.example;

import com.formdev.flatlaf.intellijthemes.FlatHiberbeeDarkIJTheme;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FlatHiberbeeDarkIJTheme.setup();
        new MainView();
    }
}
