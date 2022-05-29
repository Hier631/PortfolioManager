package org.example.main;

import com.formdev.flatlaf.intellijthemes.FlatHiberbeeDarkIJTheme;
import org.example.controller.MainController;
import org.example.utils.CayenneUtil;
import org.example.view.MainView;

public class App 
{
    public static void main( String[] args )
    {
        FlatHiberbeeDarkIJTheme.setup();

        new MainController(CayenneUtil.getContext(), new MainView());

        // CayenneUtil.shutdown();
    }
}
