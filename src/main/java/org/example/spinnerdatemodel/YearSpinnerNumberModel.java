package org.example.spinnerdatemodel;

import javax.swing.*;
import java.time.LocalDate;

public class YearSpinnerNumberModel extends SpinnerNumberModel {
    public YearSpinnerNumberModel() {
        int currentYear = LocalDate.now().getYear();

        this.setValue(currentYear);
        this.setMinimum(currentYear - 1000);
        this.setMaximum(currentYear + 1000);
        this.setStepSize(1);
    }
}
